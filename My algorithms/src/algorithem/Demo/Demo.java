package algorithem.Demo;

import io.MyCompressorOutputStream;
import mazeGenerators.Maze3d;
import mazeGenerators.SimpleMaze3dGenerator;
import Run.Methods.*;

import java.io.*;

import static Run.Methods.print;

public class Demo {

    public static void run() {
        int x = 2;
        SimpleMaze3dGenerator SMG = new SimpleMaze3dGenerator();
        Maze3d myMaze = new SimpleMaze3dGenerator().Generate(2, 4, 4);
        myMaze.printMaze();
        if (SMG.verityPathOnMaze(myMaze)) print("True");
        else print("False");

        try {
            OutputStream outFile = new MyCompressorOutputStream(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("1.maz"), "UTF-8")));
            outFile.write(myMaze.toByteArray());



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir)));
        //   out.write("1\n");out.write("1");out.write("1");out.write("1");out.write("1");out.write("1");out.write("1");
        //    out.flush();
        //   } catch (FileNotFoundException e) {
        //       e.printStackTrace();
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //    }


    }
}