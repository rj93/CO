package io.richard.sa.cost;

import io.richard.sa.Ranking;
import io.richard.sa.Tournament;

public interface Cost {
	
	public int calculate(Ranking ranking, Tournament tournament);
	
}
