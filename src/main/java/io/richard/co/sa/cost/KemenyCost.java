package io.richard.co.sa.cost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.richard.co.sa.neighbours.Neighbour;
import io.richard.co.sa.tournament.Edge;
import io.richard.co.sa.tournament.Participant;
import io.richard.co.sa.tournament.Ranking;
import io.richard.co.sa.tournament.Tournament;

public class KemenyCost implements Cost {

	@Override
	public int calculate(Ranking ranking, Tournament tournament) {
		List<Participant> ranks = ranking.getRanking();
		Set<Edge> edges = tournament.getEdges();
		
		List<Integer> processedRanks = new ArrayList<Integer>();
		int score = 0;
		for (Participant p : ranks){
			for (Edge edge : edges){
				if (edge.getStartId() == p.getId() && processedRanks.contains(edge.getEndId())){
					score += edge.getWeight();
//					System.out.println(edge + " score = " + score);
				}
			}
			processedRanks.add(p.getId());
		}
		
		return score;
	}
	
	@Override
	public int calculate(Neighbour neighbour, Tournament tournament) {
		Ranking orginal = neighbour.getOriginalRanking();
		
		List<Participant> ranks = orginal.getRanking();
		Set<Edge> edges = tournament.getEdges();
		
		int score = orginal.getCost();
		Participant p1 = ranks.get(Math.min(neighbour.getIndex1(), neighbour.getIndex2()));
		Participant p2 = ranks.get(Math.max(neighbour.getIndex1(), neighbour.getIndex2()));

		for (Edge edge : edges){
			if (edge.getStartId() == p1.getId() & edge.getEndId() == p2.getId()){
				score += edge.getWeight();
			} else if (edge.getStartId() == p2.getId() & edge.getEndId() == p1.getId()){
				score -= edge.getWeight();
			}
		}
		
		return score;
	}

}
