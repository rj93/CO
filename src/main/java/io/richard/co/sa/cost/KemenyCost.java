package io.richard.co.sa.cost;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

}
