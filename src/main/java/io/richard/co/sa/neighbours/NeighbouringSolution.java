package io.richard.co.sa.neighbours;

import java.util.Random;

import io.richard.co.sa.tournament.Ranking;

public interface NeighbouringSolution {
	
	static final Random random = new Random();
	
	public Neighbour getNeighbour(Ranking ranking);
	
}
