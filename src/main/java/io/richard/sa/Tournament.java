package io.richard.sa;

import java.util.Map;
import java.util.Set;

public class Tournament {
	
	private Map<Integer, String> participants;
	private Set<Edge> edges;

	public Tournament(Map<Integer, String> participants, Set<Edge> edges) {
		this.participants = participants;
		this.edges = edges;
	}
	
	public String getParticipantName(int id){
		return participants.get(id);
	}
	
	public Map<Integer, String> getParticipants(){
		return participants;
	}
	
	public Set<Edge> getEdges(){
		return edges;
	}
	
}
