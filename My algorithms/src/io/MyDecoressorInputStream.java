package io;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by orrko_000 on 10/09/2016.
 */
public class MyDecoressorInputStream extends InputStream {
    public MyDecoressorInputStream(InputStream in) {
        this.in = in;
    }

    InputStream in;

    @Override
    public int read() throws IOException {
        return 0;
    }
}
