package algorithem.Demo;

import algorithms.search.*;
import mazeGenerators.Coordinate;
import mazeGenerators.Maze3d;
import mazeGenerators.SimpleMaze3dGenerator;

import static Run.Methods.print;
import static mazeGenerators.Maze3dGenerator.ANSI_CYAN;
import static mazeGenerators.Maze3dGenerator.ANSI_RESET;

/**
 * Created by orrko_000 on 02/09/2016.
 */
public class Demo {


    public static void run(){

        SimpleMaze3dGenerator SMG = new SimpleMaze3dGenerator();
        Maze3d myMaze = SMG.Generate(2, 9, 11);
        boolean a = SMG.verityPathOnMaze(myMaze);
        System.out.print(ANSI_CYAN + a + "\n" + ANSI_RESET);
        myMaze.printMaze();
        State<Coordinate> StartState = new State<Coordinate>(myMaze.getEntry());
        State<Coordinate> EndState = new State<Coordinate>(myMaze.getExit());
        print("Start::");StartState.getValue().printCoordinate();
        print("End::");EndState.getValue().printCoordinate();

        Searchable<Coordinate> mts = new MazeAdapter(myMaze);
        Solution<Coordinate> solution2 = new Solution<Coordinate>();

        BFS<Coordinate> bfs = new BFS<Coordinate>();

        solution2 = bfs.search(mts);
        if (solution2!=null) {
            String s = solution2.toString();
            print(s);
        }

        System.out.println("DFS:"+bfs.getNumberOfNodesEvaluated());



    }
}
