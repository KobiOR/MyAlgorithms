/**
 * The MazeState class extends State class as object with
 *
 * @param currPlayerPosition- that object initialized with the player coordinate
 * @author Kobi Or
 * Created by orrko_000 on 02/09/2016.
 */


package algorithem.Demo;
import algorithms.search.State;
import mazeGenerators.Coordinate;

public class MazeState extends State {

    private Coordinate currPlayerPosition;

    /**
     *@return Coordinate
     * @param pos
     */
    public MazeState(Coordinate pos) {
        super(pos);
        this.currPlayerPosition = pos;
    }

    /**
     *@return Coordinate object initialized with  currPlayerPosition (mean Coordinate)
     */
    public Coordinate getCurrPlayerPosition() {
        return currPlayerPosition;
    }

    /**
     *@param currPlayerPosition  Coordinate object with currPlayerPosition (mean Coordinate)
     */
    public void setCurrPlayerPosition(Coordinate currPlayerPosition){

        this.currPlayerPosition = currPlayerPosition;
    }

}
