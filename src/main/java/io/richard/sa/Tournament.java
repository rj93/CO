package io.richard.sa;

import java.util.Map;
import java.util.Set;

public class Tournament {
	
	Map<Integer, String> participants;
	Set<Edge> edges;

	public Tournament(Map<Integer, String> participants, Set<Edge> edges) {
		this.participants = participants;
		this.edges = edges;
	}
	
	public String getParticipantName(int id){
		return participants.get(id);
	}
	
}
