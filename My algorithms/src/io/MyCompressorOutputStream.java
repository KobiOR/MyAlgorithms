package io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by orrko_000 on 10/09/2016.
 */
public class MyCompressorOutputStream extends OutputStream {


    OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        //if (b exist)

        //else (mean b doesnt exist)
    }
}
