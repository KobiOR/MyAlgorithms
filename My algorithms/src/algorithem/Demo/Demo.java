package algorithem.Demo;

import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;
import mazeGenerators.Coordinate;
import mazeGenerators.GrowingTreeGenerator;
import mazeGenerators.Maze3d;
import mazeGenerators.SimpleMaze3dGenerator;
import Run.Methods.*;

import java.io.*;

import static Run.Methods.print;

public class Demo {

    public static void run() {
        SimpleMaze3dGenerator SMG = new SimpleMaze3dGenerator();
        GrowingTreeGenerator groTreeAlgo = new GrowingTreeGenerator();
        Maze3d myMaze = myMaze = groTreeAlgo.Generate(3, 7, 9);

        while (!SMG.verityPathOnMaze(myMaze)) {
            myMaze = groTreeAlgo.Generate(3, 8, 9);
        }
        myMaze.printMaze();

        DFS<Coordinate> s2 = new DFS<Coordinate>();// create DFS searcher
        Solution<Coordinate> sol2 = s2.search(new MazeAdapter(myMaze));// run the search method to get a solution
        System.out.println("DFS solution:\n" + sol2.toString());// print the solution
        System.out.println("The number of nodes evaluated: " + s2.getNumberOfNodesEvaluated() + "\n");// print the number of nodes evaluated

        BFS<Coordinate> s1 = new BFS<Coordinate>();// create DFS searcher
        MazeAdapter mz = new MazeAdapter(myMaze);
        Solution<Coordinate> sol1 = s1.search(mz);// run the search method to get a solution
        System.out.println("BFS solution:\n" + sol1.toString());// print the solution
        System.out.println("The number of nodes evaluated: " + s1.getNumberOfNodesEvaluated() + "\n");// print the number of nodes evaluated

        try {

            OutputStream out = new MyCompressorOutputStream(new FileOutputStream("test.maz"));
            out.write(myMaze.toByteArray());
            InputStream in = new MyDecompressorInputStream(new DataInputStream(new FileInputStream("test.maz")));
            byte[] b = new byte[(int) new File("test.maz").length()];
            in.read(b);
            in.close();
            Maze3d loaded = new Maze3d(b);
            if (loaded.equal(myMaze))
                print("True!!!!\n");

        } catch (UnsupportedEncodingException e) {
            System.out.println("a");
        } catch (IOException e) {
            System.out.println("b");
        } catch (Exception e) {
            System.out.println("c");
        }


    }
    }
