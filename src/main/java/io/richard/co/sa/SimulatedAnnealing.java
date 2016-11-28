package io.richard.co.sa;

import java.util.Random;

import io.richard.co.sa.cooling.CoolingRatio;
import io.richard.co.sa.cooling.DefaultCoolingRatio;
import io.richard.co.sa.cost.Cost;
import io.richard.co.sa.cost.KemenyCost;
import io.richard.co.sa.neighbours.AdjacentNeighbouringSolution;
import io.richard.co.sa.neighbours.Neighbour;
import io.richard.co.sa.neighbours.NeighbouringSolution;
import io.richard.co.sa.tournament.Ranking;
import io.richard.co.sa.tournament.Tournament;

public class SimulatedAnnealing {
	
	private static final Random random = new Random();
	
	private final int m;
	private CoolingRatio coolingRatio;
	private Cost cost;
	private double initialTemperature = 100;
	private int temperatureLength = 100;
	private int stopIterations = 1000;
	private NeighbouringSolution neighbouringSolution = new AdjacentNeighbouringSolution();
	
	private int iterations = 0;

	public SimulatedAnnealing(int m){
		this.m = m;
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
	
	public void setNeighbouringSolution(NeighbouringSolution neighbouringSolution){
		this.neighbouringSolution = neighbouringSolution;
	}
	
	public int getIterations(){
		return iterations;
	}
	
	public Ranking anneal(Tournament tournament){
		
		iterations = 0;
		
		Ranking currentRanking = new Ranking(tournament.getParticipants());
		currentRanking.setCost(cost.calculate(currentRanking, tournament));
		double currentTemp = initialTemperature;
		
		Ranking bestRanking = currentRanking;
		while (iterations < stopIterations && bestRanking.getCost() != 0){
			for (int length = 0; length < temperatureLength; length++){
				
				if (bestRanking.getCost() == 0) break;
				if (m > 0 && iterations % m == 0) System.out.println(iterations + ") Best " + bestRanking + ", Current " + currentRanking);
				
				Neighbour neighbour = neighbouringSolution.getNeighbour(currentRanking);
				Ranking neighbourRanking = neighbour.getNeighbourRanking();
				neighbourRanking.setCost(cost.calculate(neighbour, tournament));
				int deltaC = neighbourRanking.getCost() - currentRanking.getCost();
				if (deltaC <= 0){
					currentRanking = neighbourRanking;
					if (currentRanking.getCost() < bestRanking.getCost()){
						bestRanking = currentRanking;
					}
				} else {
					double q = random.nextDouble();
					if (q < Math.pow(Math.E, (-deltaC/currentTemp))){
						currentRanking = neighbourRanking;
						// TODO Do I need to update best ranking here?
					}
				}
				
				iterations++;
			}

			currentTemp = coolingRatio.cool(currentTemp);
		}
		return bestRanking;
	}

}
