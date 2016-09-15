package algorithem.Demo;

import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;
import mazeGenerators.Maze3d;
import mazeGenerators.SimpleMaze3dGenerator;
import Run.Methods.*;

import java.io.*;

import static Run.Methods.print;

public class Demo {

    public static void run() {
        SimpleMaze3dGenerator SMG = new SimpleMaze3dGenerator();
        Maze3d myMaze = new SimpleMaze3dGenerator().Generate(8, 18, 20);
        if (SMG.verityPathOnMaze(myMaze)) print("True");
        else print("False");

        try {

            OutputStream out = new MyCompressorOutputStream(new FileOutputStream("test.maz"));
            out.write(myMaze.toByteArray());
            InputStream in = new MyDecompressorInputStream(new DataInputStream(new FileInputStream("test.maz")));
            byte[] b = new byte[(int) new File("test.maz").length()];
            in.read(b);
            in.close();
            Maze3d loaded = new Maze3d(b);
            System.out.print(loaded.getMazeString());

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

        //    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir)));
        //   out.write("1\n");out.write("1");out.write("1");out.write("1");out.write("1");out.write("1");out.write("1");
        //    out.flush();
        //   } catch (FileNotFoundException e) {
        //       e.printStackTrace();
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //    }


    }
