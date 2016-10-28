package io.richard.sa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ranking {
	
	private static final Random random = new Random();
	
	private List<Integer> ranking = new ArrayList<Integer>();
	private int cost;
	
	public Ranking(List<Integer> ranking){
		this.ranking = ranking;
	}
	
	public void addRank(int id){
		ranking.add(id);
	}
	
	public int getCost(){
		return cost;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	public List<Integer> getRanking(){
		return ranking;
	}
	
	public void swapElements(int index1, int index2){
		int temp = ranking.get(index1);
		ranking.set(index1, ranking.get(index2));
		ranking.set(index2, temp);
	}
	
	@SuppressWarnings("unchecked")
	public Ranking generateNeighbouringSolution(){
		int index1 = random.nextInt(ranking.size());
		
		// two random elements
//		int index2 = random.nextInt(ranking.size());
//		while(index2 == index1 - 1 || index2 == index1 + 1 || index1 == index2){
//			index2 = random.nextInt(ranking.size());
//		}
		
		// two neighbouring elements
		double d = random.nextDouble();
		int index2;
		if (index1 == 0 || (d < 0.5 && index1 != ranking.size() -1)){
			index2 = index1 + 1;
		} else {
			index2 = index1 - 1;
		}
		
		Ranking newRanking = new Ranking((List<Integer>) ((ArrayList<Integer>) ranking).clone());
		newRanking.swapElements(index1, index2);
		
		return newRanking;
	}
	
	public static Ranking getDefualtRanking(int c){
		List<Integer> participants = new ArrayList<Integer>();
		for (int i = 1; i <= c; i++){
			participants.add(i);
		}
		return new Ranking(participants);
	}
	
	public String toString(){		
		return "Ranking " + ranking + " = " + cost;
	}
	
	
}
