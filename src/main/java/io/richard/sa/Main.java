package io.richard.sa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.DebugGraphics;

import io.richard.sa.cooling.DefaultCoolingRatio;
import io.richard.sa.cost.Cost;
import io.richard.sa.cost.KemenyCost;
import io.richard.sa.files.Parser;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String file = "ice_dance_1998.wmg";
//		file = "example_data1.wmg"
//		file = "example_data2.wmg";
		
		Tournament t = Parser.getTournament(file);
		SimulatedAnnealing sa = new SimulatedAnnealing();
		sa.setCoolingRatio(new DefaultCoolingRatio(0.95));
		sa.setInitialTemperature(100);
		sa.setTemperatureLength(100);
		sa.setStopIterations(100);
		System.out.println(sa.anneal(t));
	}

}
