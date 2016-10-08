/**
 * The BFS class extends CommonSearcher<T> class ass Class that get Searchable object and return a solution
 *
 * @param NoValues
 * @author Kobi Or 02/09/2016.
 * @version 1.0
 * @return Solution<T> OR double
 * @exception No Throw
 * @serial no Serial
 * @see
 */

package algorithms.search;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;


public class BFS<T> extends CommonSearcher<T> {


	/**
	 *@param s get a Searchable Object and return a solution after start & finish BFS algorithm
	 *@return Solution object
	 */
	@Override
	public Solution<T> search(Searchable s) {
		if (openList == null)
			openList = new PriorityQueue<State<T>>();
		openList.add(s.getStartState());
		State start = s.getStartState();
		State goal = s.getGoalState();
		Solution sol = new Solution<T>();
		HashSet<State<T>> closed = new HashSet<>();

		closed.add(start);

		while (!openList.isEmpty())
		{
			State<T> n = openList.poll();//1
			evaluatedNodes++;
			closed.add(n);//2
			if (n.equals(goal))//3
			{
				return backTrace(n);
			}
			List<State<T>> successors = s.getAllPossibleStates(n); //4
			s.setValue(n);
			for (State<T> st : successors) { //5
				if (!closed.contains(st) && !openList.contains(st)) {
					st.setCameFrom(n);
					openList.add(st);
				} else {
					if (costCalculator(n) < st.getCost())
						if (!openList.contains(st)) {
							st.setCameFrom(n);
							openList.add(st);
						} else {
							openList.poll();//1
							evaluatedNodes++;
							st.setCameFrom(n);
							st.setCost(costCalculator(n));
							openList.add(st);
						}
				}
			}
		}
		return sol;
	}
	/**
	 *@param s get a State Object and return the time between the getCameFrom() object.increase it by one
	 *@return double
	 */
	public double costCalculator(State<T> s) {
		if (s.getCameFrom() == null)
			return 0;
		return s.getCost() + 1;
	}
}