package algorithem.Demo;

import algorithms.search.*;
import io.MyCompressorOutputStream;
import mazeGenerators.Coordinate;
import mazeGenerators.Maze3d;
import mazeGenerators.SimpleMaze3dGenerator;

import java.io.IOException;
import java.io.OutputStream;
import java.io.*;

import static Run.Methods.print;
import static mazeGenerators.Maze3dGenerator.ANSI_CYAN;
import static mazeGenerators.Maze3dGenerator.ANSI_RESET;

public class Demo {


    public static void run() throws IOException {

        SimpleMaze3dGenerator SMG = new SimpleMaze3dGenerator();
        Maze3d myMaze = SMG.Generate(2, 5, 7);
        boolean a = SMG.verityPathOnMaze(myMaze);
        System.out.print(ANSI_CYAN + a + "\n" + ANSI_RESET);
        myMaze.printMaze();
        State<Coordinate> StartState = new State<Coordinate>(myMaze.getEntry());
        State<Coordinate> EndState = new State<Coordinate>(myMaze.getExit());
        print("Start::");StartState.getValue().printCoordinate();
        print("End::");EndState.getValue().printCoordinate();

        //  Searchable<Coordinate> mts = new MazeAdapter(myMaze);
        //Solution<Coordinate> solution2 = new Solution<Coordinate>();

        //   BFS<Coordinate> bfs = new BFS<Coordinate>();

        // solution2 = bfs.search(mts);
        // if (solution2!=null) {
        //     String s = solution2.toString();
        //      print(s);
        //  }

        //   System.out.println("DFS:"+bfs.getNumberOfNodesEvaluated());


        OutputStream out = null;
        try {
            out = new MyCompressorOutputStream(new FileOutputStream("1.maz"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (myMaze.toByteArray() != null)
            out.write(myMaze.toByteArray());
        out.flush();
        out.close();
        // InputStream in=new MyDecompressorInputStream(
        //      new FileOutputStream("1.maz"));
        //    byte b[]=new byte[maze.toByteArray().length];
        //   in.read(b);
        //   in.close();
        //  Maze3d loaded=new Maze3d(b);
        //  System.out.println(loaded.equals(maze));

    }
}
