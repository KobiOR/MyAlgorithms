package io;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyDecompressorInputStream extends InputStream {
    private DataInputStream in;

    public MyDecompressorInputStream(DataInputStream in) {
        this.in = in;
    }
    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int i = 0;
        while (in.available() > 0) {
            b[i] = in.readByte();
            i++;
        }
        return 1;


    }
}