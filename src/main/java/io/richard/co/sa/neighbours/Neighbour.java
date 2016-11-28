package io.richard.co.sa.neighbours;

import io.richard.co.sa.tournament.Ranking;

public class Neighbour {
	
	private Ranking originalRanking;
	private Ranking neighbourRanking;
	private int index1;
	private int index2;
	
	public Neighbour(Ranking r1, Ranking r2, int index1, int index2){
		this.originalRanking = r1;
		this.neighbourRanking = r2;
		this.index1 = index1;
		this.index2 = index2;
	}

	public Ranking getOriginalRanking() {
		return originalRanking;
	}

	public Ranking getNeighbourRanking() {
		return neighbourRanking;
	}

	public int getIndex1() {
		return index1;
	}

	public int getIndex2() {
		return index2;
	}

	
}
