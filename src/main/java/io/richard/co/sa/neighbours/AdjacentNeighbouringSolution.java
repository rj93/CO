package io.richard.co.sa.neighbours;

import java.util.ArrayList;
import java.util.List;

import io.richard.co.sa.tournament.Participant;
import io.richard.co.sa.tournament.Ranking;

public class AdjacentNeighbouringSolution implements NeighbouringSolution {

	@Override
	public Neighbour getNeighbour(Ranking ranking) {
		int size = ranking.getRanking().size();
		int index1 = random.nextInt(size);
		
		double d = random.nextDouble();
		int index2;
		if (index1 == 0 || (d < 0.5 && index1 != size -1)){
			index2 = index1 + 1;
		} else {
			index2 = index1 - 1;
		}

		Ranking newRanking = new Ranking((List<Participant>) ((ArrayList<Participant>) ranking.getRanking()).clone());
		newRanking.swapElements(index1, index2);
		
		return new Neighbour(ranking, newRanking, index1, index2);
	}

}
