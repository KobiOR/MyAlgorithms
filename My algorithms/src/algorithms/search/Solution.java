package algorithms.search;

import java.util.ArrayList;
import java.util.List;

import static Run.Methods.print;

public class Solution<T> {


    private List<State<T>> states = new ArrayList<State<T>>();

    public Solution() {
    }

    public Solution(List<State<T>> states) {
        this.states = states;
    }

	public List<State<T>> getStates() {
		return states;
	}
	public void setStates(List<State<T>> states) {
		this.states = states;
	}

    @Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
        int index = states.size();
        for (State<T> s : states) {
            index--;
            sb.append(s.toString());
            if (index != 0) sb.append("->");
        }
		return sb.toString();
	}
	public void addState(State<T> s) {
		states.add(s);
	}
}


