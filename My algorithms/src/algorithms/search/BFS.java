package algorithms.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;


public class BFS<T> extends CommonSearcher<T> {


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
				return back(n, s.getStartState());
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

	public double costCalculator(State<T> s) {
		if (s.getCameFrom() == null)
			return 0;
		return s.getCost() + 1;
	}
}