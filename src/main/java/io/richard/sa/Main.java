package io.richard.sa;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.richard.sa.files.Parser;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String file = "ice_dance_1998.wmg";
		
//		System.out.println(Parser.getParticipants(file));
//		System.out.println(Parser.getEdges(file));
		System.out.println(Parser.getTournament(file));
	}

}
