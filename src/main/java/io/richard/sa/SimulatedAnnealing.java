package io.richard.sa;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import io.richard.sa.cooling.CoolingRatio;
import io.richard.sa.cooling.DefaultCoolingRatio;
import io.richard.sa.cost.Cost;
import io.richard.sa.cost.KemenyCost;

public class SimulatedAnnealing {
	
	private static final Random random = new Random();
	
	private CoolingRatio coolingRatio;
	private Cost cost;
	private double initialTemperature = 1000;
	private int temperatureLength = 100;
	private int stopIterations = 1000;
	
	public SimulatedAnnealing(){
		coolingRatio = new DefaultCoolingRatio();
		cost = new KemenyCost();
	}
	
	public SimulatedAnnealing(CoolingRatio coolingRatio, Cost cost){
		this.coolingRatio = coolingRatio;
		this.cost = cost;
	}
	
	public Ranking anneal(Tournament tournament){
		
		Map<Ranking, Integer> rankings = new HashMap<Ranking, Integer>();
		
		Ranking currentRanking = Ranking.getDefualtRanking(tournament.getParticipants().size());
//		rankings.put(currentRanking, cost.calculate(currentRanking, tournament));
		double currentTemp = initialTemperature;
		
		int counter = 0;
		while (counter < stopIterations){
			rankings.put(currentRanking, cost.calculate(currentRanking, tournament));
			for (int length = 0; length < temperatureLength; length++){
				Ranking neighbour = currentRanking.generateNeighbouringSolution();
				int deltaC = cost.calculate(neighbour, tournament) - cost.calculate(currentRanking, tournament);
//				System.out.println(neighbour + " = " + cost.calculate(neighbour, tournament) + ", " + cost.calculate(currentRanking, tournament));
				if (deltaC <= 0){
					currentRanking = neighbour;
				} else {
					double q = random.nextDouble();
					if (q < Math.pow(Math.E, (-deltaC/currentTemp))){
						currentRanking = neighbour;
					}	
				}
				
			}
			currentTemp = coolingRatio.cool(currentTemp);
			counter++;
		}
		
		Ranking bestR = null;
		int bestC = Integer.MAX_VALUE;
		for (Map.Entry<Ranking, Integer> entry : rankings.entrySet()){
			if (entry.getValue() < bestC){
				bestC = entry.getValue();
				bestR = entry.getKey();
			}
		}
//		System.out.println(rankings);
		System.out.println(bestR + " = " + bestC);
		return bestR;
	}

}
