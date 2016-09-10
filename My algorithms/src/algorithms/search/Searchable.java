package algorithms.search;

import mazeGenerators.Coordinate;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
/**
 * Interface that represents a problem that we can search for a solution for
 * @author roiyeho
 *
 * @param <T>
 */
public interface Searchable<T> {
	/**
	 * Returns the initial state
	 * @return 
	 */
	State<T> getStartState();
	State<T> getGoalState();
	/**
	 * Returns all the states we can go to from the current state
	 * @param s the current state
	 * @return
	 */
	List<State<T>> getAllPossibleStates(State<T> s);
	double getMoveCost(State<T> currState, State<T> neighbor);
}
