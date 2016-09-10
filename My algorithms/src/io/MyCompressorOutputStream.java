package io;

import algorithms.search.State;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Stack;

import static sun.misc.Version.print;

public class MyCompressorOutputStream extends OutputStream {
    private BufferedWriter out;

    public MyCompressorOutputStream(BufferedWriter out) {
        this.out = out;
    }
    @Override
    public void write(int b) throws IOException {
        if (b > 9) {
            writeBig(b);
        } else {
            char a = (char) (b + '0');
            out.write(a);
            out.write("\n");
            out.flush();
        }
    }

    @Override
    public void write(byte[] b) throws IOException {
        for (int i = 0; i < b.length; i++) {
            write((int) b[i]);
        }

    }

    private void writeBig(int x) throws IOException {
        Stack<Integer> st = new Stack<>();
        while (x != 0 && x > 9)
            st.push(x = x % 10);
        st.push(x);
        while (!st.isEmpty()) {
            char a = (char) (st.pop() + '0');
            out.write(a);
        }
        out.write("\n");
        out.flush();
    }
}
