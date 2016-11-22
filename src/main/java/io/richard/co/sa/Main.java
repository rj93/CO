package io.richard.co.sa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import io.richard.co.sa.cooling.DefaultCoolingRatio;
import io.richard.co.sa.files.Parser;
import io.richard.co.sa.neighbours.AdjacentNeighbouringSolution;
import io.richard.co.sa.neighbours.RandomNeighbouringSolution;
import io.richard.co.sa.tournament.Ranking;
import io.richard.co.sa.tournament.Tournament;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		if (args.length != 1)
			throw new IllegalArgumentException();
		
		String file = args[0];
//		file = "example_data.wmg";
//		file = "example_data2.wmg";
		
		Scanner sIn = new Scanner(System.in);
		System.out.print("Enter m: ");
		int m = sIn.nextInt();
		sIn.close();
		
		
		Tournament t = Parser.getTournament(file);
		SimulatedAnnealing sa = new SimulatedAnnealing(m);
		sa.setCoolingRatio(new DefaultCoolingRatio(0.95));
		sa.setInitialTemperature(100);
		sa.setTemperatureLength(100);
		sa.setStopIterations(10000);
		sa.setNeighbouringSolution(new AdjacentNeighbouringSolution());
		Ranking r = sa.anneal(t);
		
		System.out.println(r);
	}

}
