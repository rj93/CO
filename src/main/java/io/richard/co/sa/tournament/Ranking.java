package io.richard.co.sa.tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ranking {
	
	private List<Participant> ranking = new ArrayList<Participant>();
	private int cost;
	
	public Ranking(List<Participant> ranking){
		this.ranking = ranking;
	}
	
	public void addRank(Participant p){
		ranking.add(p);
	}
	
	public int getCost(){
		return cost;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	public List<Participant> getRanking(){
		return ranking;
	}
	
	public void swapElements(int index1, int index2){
		Participant temp = ranking.get(index1);
		ranking.set(index1, ranking.get(index2));
		ranking.set(index2, temp);
	}
	
	public String toString(){		
		return "Ranking " + ranking + " = " + cost;
	}
	
	public void pretty(){
		int i = 1;
		for (Participant p : ranking){
			System.out.println(i++ + ". " + p);
		}
	}
	
	
}
