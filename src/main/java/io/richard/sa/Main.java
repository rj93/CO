package io.richard.sa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import io.richard.sa.cost.Cost;
import io.richard.sa.cost.KemenyCost;
import io.richard.sa.files.Parser;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String file = "ice_dance_1998.wmg";
//		file = "example_data2.wmg";
		
//		System.out.println(Parser.getParticipants(file));
//		System.out.println(Parser.getEdges(file));
//		System.out.println(Parser.getTournament(file));
		
		
		Tournament t = Parser.getTournament(file);
		
		
		SimulatedAnnealing sa = new SimulatedAnnealing();
		sa.anneal(t);
		
//		int A = 1;
//		int B = 2;
//		int C = 3;
//		int D = 4;
//		Cost c = new KemenyCost();
//		
//		Ranking r1 = new Ranking(Arrays.asList(A, B, C, D));
//		System.out.println(r1 + " = " + c.calculate(r1, t));
//		
//		Ranking r2 = new Ranking(Arrays.asList(B, D, C, A));
//		System.out.println(r2 + " = " + c.calculate(r2, t));
//		
//		Ranking r3 = new Ranking(Arrays.asList(A, B, D, C));
//		System.out.println(r3 + " = " + c.calculate(r3, t));
	}

}
