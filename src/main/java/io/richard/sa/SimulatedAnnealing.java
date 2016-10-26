package io.richard.sa;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import io.richard.sa.cooling.CoolingRatio;
import io.richard.sa.cooling.DefaultCoolingRatio;
import io.richard.sa.cost.Cost;
import io.richard.sa.cost.KemenyCost;

public class SimulatedAnnealing {
	
	private static final Random random = new Random();
	
	private CoolingRatio coolingRatio;
	private Cost cost;
	private double initialTemperature;
	private int temperatureLength;
	private int stopIterations = 100;
	
	public SimulatedAnnealing(){
		coolingRatio = new DefaultCoolingRatio();
		cost = new KemenyCost();
	}
	
	public SimulatedAnnealing(CoolingRatio coolingRatio, Cost cost){
		this.coolingRatio = coolingRatio;
		this.cost = cost;
	}
	
	public Ranking anneal(Tournament tournament){
		
		Set<Ranking> rankings = new HashSet<Ranking>();
		
		Ranking currentRanking = Ranking.getDefualtRanking();
		rankings.add(currentRanking);
		double currentTemp = initialTemperature;
		
		int counter = 0;
		while (counter < stopIterations){
			for (int length = 0; length < temperatureLength; length++){
				Ranking neighbour = currentRanking.generateNeighbouringSolution();
				int deltaC = cost.calculate(neighbour, tournament) - cost.calculate(currentRanking, tournament);
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
		}
		
		return null;
	}

}
