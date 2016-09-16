package algorithms.search;

import java.util.ArrayList;
import java.util.List;

import static Run.Methods.print;

public class Solution<T> {
	private List<State<T>> states = new ArrayList<State<T>>();
	public List<State<T>> getStates() {
		return states;
	}
	public void setStates(List<State<T>> states) {
		this.states = states;
	}
		@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (State<T> s : states) {
			sb.append(s.toString()).append("->");
		}
		return sb.toString();
	}
	public void print1() {
		String s=toString();
			print(s);
	}

	public void addState(State<T> s) {
		states.add(s);
	}

	public void setValuesOnMaze(State<T> s) {


	}
}


