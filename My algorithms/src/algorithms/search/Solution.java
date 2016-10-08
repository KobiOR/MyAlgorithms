/**
 * The Solution<T> class represent a solution with arrayList
 *
 * @param states
 * @author Kobi Or 02/09/2016.
 * @version 1.0
 * @return Solution<T> OR double
 * @exception No Throw
 * @serial no Serial
 * @see
 */


package algorithms.search;
import java.util.ArrayList;
import java.util.List;

public class Solution<T> {
    private List<State<T>> states = new ArrayList<State<T>>();

    public Solution() {
    }

    public Solution(List<State<T>> states) {
        this.states = states;
    }

    /**
     * @return states list
     */
    public List<State<T>> getStates() {
        return states;
	}

    /**
     * set the states list
     *
     * @param states
     */
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


