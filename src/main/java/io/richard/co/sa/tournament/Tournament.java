package io.richard.co.sa.tournament;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tournament {
	
	private List<Participant> participants;
	private Set<Edge> edges;

	public Tournament(List<Participant> participants, Set<Edge> edges) {
		this.participants = participants;
		this.edges = edges;
	}
	
	public List<Participant> getParticipants(){
		return participants;
	}
	
	public Set<Edge> getEdges(){
		return edges;
	}
	
}
