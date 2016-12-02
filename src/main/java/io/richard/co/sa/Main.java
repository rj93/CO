package io.richard.co.sa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import io.richard.co.sa.cooling.DefaultCoolingRatio;
import io.richard.co.sa.files.Parser;
import io.richard.co.sa.neighbours.AdjacentNeighbouringSolution;
import io.richard.co.sa.tournament.Ranking;
import io.richard.co.sa.tournament.Tournament;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		if (args.length != 1)
			throw new IllegalArgumentException();
		
		String file = args[0];
		
		Scanner sIn = new Scanner(System.in);
		System.out.print("Enter m: ");
		int m = sIn.nextInt();
		sIn.close();		
		
		Tournament t = Parser.getTournament(file);
		SimulatedAnnealing sa = new SimulatedAnnealing(m);
		sa.setCoolingRatio(new DefaultCoolingRatio(0.95));
		sa.setInitialTemperature(100);
		sa.setTemperatureLength(10);
		sa.setStopIterations(10000);
		sa.setNeighbouringSolution(new AdjacentNeighbouringSolution());
		
		long start = System.nanoTime();
		Ranking r = sa.anneal(t);
		long diff = System.nanoTime() - start;
		
		r.pretty();
		System.out.println("Kemeny Cost = " + r.getCost());
		System.out.println("Time taken = " + diff / 1000000 + "ms");
		
	}

}
