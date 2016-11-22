package io.richard.sa.neighbours;

import java.util.ArrayList;
import java.util.List;

import io.richard.sa.Participant;
import io.richard.sa.Ranking;

public class AdjacentNeighbouringSolution implements NeighbouringSolution {

	@Override
	public Ranking getNeighbour(Ranking ranking) {
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
		
		return newRanking;
	}

}
