package algorithem.Demo;

import algorithms.search.Searchable;
import algorithms.search.State;
import mazeGenerators.Coordinate;
import mazeGenerators.Maze3d;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by orrko_000 on 02/09/2016.
 */
public class MazeAdapter implements Searchable<Coordinate> {
    public Maze3d myMaze;
    public MazeAdapter(Maze3d newMaze) {
        this.myMaze=new Maze3d(newMaze);
    }
    @Override
    public State getStartState() {
        Coordinate start=new Coordinate(myMaze.getEntry());
        State <Coordinate> startState=new State<Coordinate>(start);
        return startState;
    }
    @Override
    public State getGoalState() {
        Coordinate exit=new Coordinate(myMaze.getExit());
        State <Coordinate> exitState=new State<Coordinate>(exit);
        return exitState;
    }
    @Override
    public List<State<Coordinate>> getAllPossibleStates(State<Coordinate> s)    {
        List<State<Coordinate>> movesList=new ArrayList<State<Coordinate>>();
        if (!myMaze.WallExist(s.getValue().UP())){myMaze.setValueByCoor(s.getValue().UP(),1);
            movesList.add(new State<Coordinate>(s.getValue().UP()));}

        if (!myMaze.WallExist(s.getValue().DOWN())){myMaze.setValueByCoor(s.getValue().DOWN(),1);
            movesList.add(new State<Coordinate>(s.getValue().DOWN()));}

        if (!myMaze.WallExist(s.getValue().LEFT())){myMaze.setValueByCoor(s.getValue().LEFT(),1);
            movesList.add(new State<Coordinate>(s.getValue().LEFT()));}

        if (!myMaze.WallExist(s.getValue().RIGHT())){myMaze.setValueByCoor(s.getValue().RIGHT(),1);
            movesList.add(new State<Coordinate>(s.getValue().RIGHT()));}

        if (!myMaze.WallExist(s.getValue().BACKWORDS())){myMaze.setValueByCoor(s.getValue().BACKWORDS(),1);
            movesList.add(new State<Coordinate>(s.getValue().BACKWORDS()));}

        if (!myMaze.WallExist(s.getValue().STRAIGHT())){myMaze.setValueByCoor(s.getValue().STRAIGHT(),1);
            movesList.add(new State<Coordinate>(s.getValue().STRAIGHT()));}

        return movesList;
    }

    @Override
    public double getMoveCost(State currState, State neighbor) {
        return 0;
    }

}

