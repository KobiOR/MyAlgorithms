/**
 * DFS CLASS
 * itarative algorithem
 * @param hashMap for print the nodes on the graph
 * @param st  this is the stack for the algorithem
 *
 */
package algorithms.search;
import mazeGenerators.Coordinate;

import java.util.ArrayList;

import java.util.*;

import static Run.Methods.print;
import static algorithms.search.Color.BLACK;
import static algorithms.search.Color.GREY;
import static algorithms.search.Color.WHITE;

/**
 * Created by orrko_000 on 29/08/2016.
 */
enum Color {
    WHITE,GREY,BLACK;

}

public class DFS<T> extends CommonSearcher {

    HashMap<State<T>, Color> hashMap = new HashMap<State<T>, Color>();
    Solution<T> solution = new Solution<T>();
    Stack<State<T>> st = new Stack<State<T>>();
    List<State<T>> neighbors=new ArrayList<State<T>>();
    @Override
    public Solution<T> search(Searchable s) {

        st.push(s.getStartState());
        while(!st.isEmpty())
        {
            State<T> state=st.pop();
            hashMap.put(state,GREY);
            if (state.getValue().equals(s.getGoalState().getValue()))
                return getPath(st);
            neighbors=s.getAllPossibleStates(state);
            if (neighbors!=null)
                for (State <T> sta :neighbors)
                    if (hashMap.containsKey(sta)==false) {
                        hashMap.put(sta, WHITE);
                        st.push(sta);
                    }


            hashMap.replace(state,GREY,BLACK);

        }
        return null;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof State))
            return false;
        if (obj.equals(this))
            return true;
            else return  false;

    }
    private Solution<T> getPath (Stack<State<T>> st){
        for (int i = 0; i <st.size() ; i++) {
            print(st.pop().getValue().toString());
        }
            return null;
    }


}
