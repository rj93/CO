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
	private double initialTemperature = 100;
	private int temperatureLength = 100;
	private int stopIterations = 100;

	public SimulatedAnnealing(){
		coolingRatio = new DefaultCoolingRatio();
		cost = new KemenyCost();
	}
	
	public void setCoolingRatio(CoolingRatio coolingRatio){
		this.coolingRatio = coolingRatio;
	}
	
	public void setCost(Cost cost) {
		this.cost = cost;
	}

	public void setInitialTemperature(double initialTemperature) {
		this.initialTemperature = initialTemperature;
	}

	public void setTemperatureLength(int temperatureLength) {
		this.temperatureLength = temperatureLength;
	}

	public void setStopIterations(int stopIterations) {
		this.stopIterations = stopIterations;
	}
	
	public Ranking anneal(Tournament tournament){
		
		Ranking currentRanking = Ranking.getDefualtRanking(tournament.getParticipants().size());
		currentRanking.setCost(cost.calculate(currentRanking, tournament));
		double currentTemp = initialTemperature;
		
		int counter = 0;
		Ranking best = currentRanking;
		while (counter < stopIterations){
			for (int length = 0; length < temperatureLength; length++){
				Ranking neighbour = currentRanking.generateNeighbouringSolution();
				neighbour.setCost(cost.calculate(neighbour, tournament));
				int deltaC = neighbour.getCost() - currentRanking.getCost();
//				System.out.print("new = " + cost.calculate(neighbour, tournament) + ", old = " + cost.calculate(currentRanking, tournament));
				if (deltaC <= 0){
					currentRanking = neighbour;
					if (currentRanking.getCost() < best.getCost()){
						best = currentRanking;
					}
//					System.out.print(" accepted");
				} else {
					double q = random.nextDouble();
					if (q < Math.pow(Math.E, (-deltaC/currentTemp))){
						currentRanking = neighbour;
//						System.out.print(" accepted (q = " + q + " prob = " + Math.pow(Math.E, (-deltaC/currentTemp)) + ")");
					}	
				}
//				System.out.println();
			}

			currentTemp = coolingRatio.cool(currentTemp);
			counter++;
		}
		
		return best;
	}

}
