package io.richard.sa.neighbours;

import java.util.Random;

import io.richard.sa.Ranking;

public interface NeighbouringSolution {
	
	static final Random random = new Random();
	
	public Ranking getNeighbour(Ranking ranking);
	
}
