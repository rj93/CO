package io.richard.sa.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.richard.sa.Edge;
import io.richard.sa.Tournament;

public class Parser {
	
	private static Map<Integer, String> getParticipants(BufferedReader br) throws IOException {

		int noOfParticipants = Integer.parseInt(br.readLine());
		
		Map<Integer, String> participants = new HashMap<Integer, String>();	
		for (int i = 0; i < noOfParticipants; i++){
			String parts[] = br.readLine().split(",");
			int id = Integer.parseInt(parts[0]);
			String name = parts[1];
			participants.put(id, name);
		}
		return participants;
	}
	
	private static Set<Edge> getEdges(BufferedReader br) throws FileNotFoundException, IOException{
		
		Set<Edge> edges = new HashSet<Edge>();
		
		String line;
		while ((line = br.readLine()) != null){
			String parts[] = line.split(",");
			int weight = Integer.parseInt(parts[0]);
			int startId = Integer.parseInt(parts[1]);
			int endId = Integer.parseInt(parts[2]);
			edges.add(new Edge(startId, endId, weight));
		}
		
		return edges;
	}
	
	public static Tournament getTournament(String file) throws FileNotFoundException, IOException{
		
		Tournament tournament = null;
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			Map<Integer, String> participants = getParticipants(br);
			br.readLine(); // skip "how data was generated" line
			Set<Edge> edges = getEdges(br);
			
			tournament = new Tournament(participants, edges);

			System.out.println(participants);
			System.out.println(edges);
		}
		
		return tournament;
	}
	
}
