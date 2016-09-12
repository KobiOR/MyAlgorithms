package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

    private OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {
        Integer newInt = b;
        out.write(newInt.byteValue());
        out.flush();
    }
    @Override
    public void write(byte[] b) throws IOException {
        for (int i = 0; i < b.length; i++) {
            write((int) b[i]);
        }
        out.close();


    }


}
