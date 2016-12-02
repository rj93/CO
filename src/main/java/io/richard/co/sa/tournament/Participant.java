package io.richard.co.sa.tournament;

public class Participant {
	
	private int id;
	private String name;
	
	public Participant (int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
//		return String.valueOf(id);
		return name;
	}
}
