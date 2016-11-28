package io.richard.co.sa.cost;

import io.richard.co.sa.neighbours.Neighbour;
import io.richard.co.sa.tournament.Ranking;
import io.richard.co.sa.tournament.Tournament;

public interface Cost {
	
	public int calculate(Ranking ranking, Tournament tournament);
	
	public int calculate(Neighbour neighbour, Tournament tournament);
	
}
