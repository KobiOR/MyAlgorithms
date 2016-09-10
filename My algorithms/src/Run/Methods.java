package Run;

import java.util.Objects;

import static mazeGenerators.Maze3dGenerator.*;

/**
 * Created by orrko_000 on 02/09/2016.
 */
public class Methods {

    public static void print(Objects someObject)
    {

            print("Unrecognize Type");
    }

    public static void print(String s) {
        System.out.print(ANSI_BOLD+s+ANSI_BOLD_END);
    }

}

