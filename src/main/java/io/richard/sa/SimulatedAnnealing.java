package io.richard.sa;

import io.richard.sa.cooling.CoolingRatio;
import io.richard.sa.cooling.DefaultCoolingRatio;
import io.richard.sa.cost.Cost;
import io.richard.sa.cost.KemenyCost;

public class SimulatedAnnealing {
	
	private CoolingRatio coolingRatio;
	private Cost cost;
	private int initialTemperature;
	private int temperatureLength;
	
	public SimulatedAnnealing(){
		coolingRatio = new DefaultCoolingRatio();
		cost = new KemenyCost();
	}
	
	public SimulatedAnnealing(CoolingRatio coolingRatio, Cost cost){
		this.coolingRatio = coolingRatio;
		this.cost = cost;
	}
	
	public Ranking anneal(){
		
		return null;
	}

}
