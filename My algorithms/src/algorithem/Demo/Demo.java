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
        Maze3d myMaze = new SimpleMaze3dGenerator().Generate(2, 4, 4);
        if (SMG.verityPathOnMaze(myMaze)) print("True");
        else print("False");

        try {

            OutputStream out = new MyCompressorOutputStream(new FileOutputStream("test.maz"));
            out.write(myMaze.toByteArray());
            InputStream in = new MyDecompressorInputStream(new DataInputStream(new FileInputStream("test.maz")));
            byte b[] = new byte[myMaze.toByteArray().length];
            in.read(b);
            in.close();
            Maze3d loaded = new Maze3d(b);
            if (loaded.equal(myMaze))
                print("True!!!!");


        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
