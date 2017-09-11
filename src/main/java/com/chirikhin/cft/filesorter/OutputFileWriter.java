package com.chirikhin.cft.filesorter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OutputFileWriter {
    private final String filename;

    public OutputFileWriter(String filename) {
        this.filename = filename;
    }

    public void write(Object[] strings) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter("./".concat(filename))) {
            for(Object string : strings) {
                printWriter.println(string);
            }
        }
    }
}
