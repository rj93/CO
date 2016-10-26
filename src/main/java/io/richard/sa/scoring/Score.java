package io.richard.sa.scoring;

import io.richard.sa.Tournament;

public interface Score {
	public int score(Ranking ranking, Tournament tournament);
}
