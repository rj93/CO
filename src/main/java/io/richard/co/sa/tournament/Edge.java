package io.richard.co.sa.tournament;

public class Edge {
	
	private int startId;
	private int endId;
	private int weight;
	
	public Edge(int start, int end, int weight){
		this.startId = start;
		this.endId = end;
		this.weight = weight;
	}

	public int getStartId() {
		return startId;
	}

	public int getEndId() {
		return endId;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endId;
		result = prime * result + startId;
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (endId != other.endId)
			return false;
		if (startId != other.startId)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [startId=" + startId + ", endId=" + endId + ", weight=" + weight + "]";
	}
	
	
}
