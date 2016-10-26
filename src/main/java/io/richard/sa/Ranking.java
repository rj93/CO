package io.richard.sa;

import java.util.ArrayList;
import java.util.List;

public class Ranking {
	
	List<Integer> ranking = new ArrayList<Integer>();
	
	public Ranking(List<Integer> ranking){
		this.ranking = ranking;
	}
	
	public void addRank(int id){
		ranking.add(id);
	}
	
	public void swapElements(int index1, int index2){
		
	}
	
	public Ranking generateNeighbouringSolution(){
		
		return null;
	}
	
	
}
