package algorithem.Demo;

import algorithms.search.State;
import mazeGenerators.Coordinate;

/**
 * Created by orrko_000 on 02/09/2016.
 */
public class MazeState extends State {

    private Coordinate currPlayerPosition;
    public MazeState(Coordinate pos) {
        super(pos);
        this.currPlayerPosition = pos;
       // this.setDescription(pos.toString());
    }

    public Coordinate getCurrPlayerPosition() {
        return currPlayerPosition;
    }
    public void setCurrPlayerPosition(Coordinate currPlayerPosition){

        this.currPlayerPosition = currPlayerPosition;
    }

}
