/**
 * The abstract class CommonSearcher<T> implements Searcher
 *@param openList- PriorityQueue that old the Coordinate  through State objects
 *@author Kobi Or 12/09/2016.
 */
package algorithms.search;

import java.util.List;
import java.util.PriorityQueue;

public abstract class CommonSearcher<T> implements Searcher {
	protected PriorityQueue<State<T>> openList;
	protected int evaluatedNodes;

	/**
	 * @return evaluatedNodes (int type)-Counter
	 */
	@Override
	public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}

	/**
	 * @return Solution<T> object after do back trace from one coor' to a other coor' object
	 */
	protected Solution<T> backTrace(State<T> goalState) {
		Solution<T> sol = new Solution<T>();
		State<T> currState = goalState;
		List<State<T>> states = sol.getStates();
		while (currState != null) {
			evaluatedNodes++;
			states.add(0, currState);
			currState = currState.getCameFrom();
		}

			return sol;
	}

	/**
	 * @return Solution<T> (OPPOSITE SOLUTION!!!) object after do back trace from one coor' to a other coor' object
	 */
	protected Solution<T> back(State<T> s, State<T> start) {
        Solution<T> sol = new Solution<T>();
		while (!s.equals(start)) {
			sol.addState(s);
			s = s.getCameFrom();
		}
		return sol;
	}
}


