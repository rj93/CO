package io.richard.sa.neighbours;

import java.util.ArrayList;
import java.util.List;

import io.richard.sa.Participant;
import io.richard.sa.Ranking;

public class RandomNeighbouringSolution implements NeighbouringSolution {

	@Override
	public Ranking getNeighbour(Ranking ranking) {
		int size = ranking.getRanking().size();
		int index1 = random.nextInt(size);
		
		int index2 = random.nextInt(size);
		while(index2 == index1 - 1 || index2 == index1 + 1 || index1 == index2){
			index2 = random.nextInt(size);
		}
		
		Ranking newRanking = new Ranking((List<Participant>) ((ArrayList<Participant>) ranking.getRanking()).clone());
		newRanking.swapElements(index1, index2);
		
		return newRanking;
	}

}
