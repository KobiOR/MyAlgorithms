package Run;

import java.io.IOException;

import static algorithem.Demo.Demo.run;

/**
 * Created by orrko_000 on 03/09/2016.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
