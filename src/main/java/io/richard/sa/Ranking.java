package io.richard.sa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ranking {
	
	private static final Random random = new Random();
	
	private List<Integer> ranking = new ArrayList<Integer>();
	
	public Ranking(List<Integer> ranking){
		this.ranking = ranking;
	}
	
	public void addRank(int id){
		ranking.add(id);
	}
	
	public void swapElements(int index1, int index2){
		int temp = ranking.get(index1);
		ranking.set(index1, ranking.get(index2));
		ranking.set(index2, temp);
	}
	
	public Ranking generateNeighbouringSolution(){
		int index1 = random.nextInt(ranking.size());
		int index2 = random.nextInt(ranking.size());
		while(index2 == index1 - 1 || index2 == index1 + 1 || index1 == index2){
			index2 = random.nextInt(ranking.size());
		}
		
		Ranking newRanking = new Ranking(ranking);
		newRanking.swapElements(index1, index2);
		
		return newRanking;
	}
	
	public static Ranking getDefualtRanking(){
		List<Integer> participants = new ArrayList<Integer>();
		for (int i = 1; i < 25; i++){
			participants.add(i);
		}
		return new Ranking(participants);
	}
	
	
}
