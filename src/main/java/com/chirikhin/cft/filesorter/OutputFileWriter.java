package com.chirikhin.cft.filesorter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OutputFileWriter {
    private OutputFileWriter() {

    }

    public static void write(String filename, Object[] strings) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter("./".concat(filename))) {
            for(Object string : strings) {
                printWriter.println(string);
            }
        }
    }
}
