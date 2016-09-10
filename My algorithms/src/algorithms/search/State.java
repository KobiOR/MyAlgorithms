package algorithms.search;

import mazeGenerators.Coordinate;

import static Run.Methods.print;

public class State<T> implements Comparable<State<T>>
{
	private State<T> cameFrom;
	private double cost;
	private T value;
	private boolean visit;
	
	public State<T> getCameFrom() {
		return cameFrom;
	}
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public State(T value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return value.toString();
	}
	@Override
	public boolean equals(Object other){
		boolean result=false;
		if((other == null) || (getClass() != other.getClass()))
		{
			result = false;
		}
		else
			{
			State<Coordinate> otherPeople = (State<Coordinate>) other;
				result=otherPeople.value.equals(this.value);
		}

		return result;
	} // end equals
	@Override
	public int compareTo(State<T> s) {
	return (int)(this.getCost() - s.getCost());
		// return > 0 if this > s
		//        < 0 if this < s
		//        = 0 if this == s
	}

}
