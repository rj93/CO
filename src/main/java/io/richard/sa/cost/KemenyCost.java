package io.richard.sa.cost;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import io.richard.sa.Edge;
import io.richard.sa.Participant;
import io.richard.sa.Ranking;
import io.richard.sa.Tournament;

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
