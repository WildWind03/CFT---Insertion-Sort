package com.chirikhin.cft.util;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class IOUtil {
    private IOUtil() {

    }

    public static void write(String filename, Object[] strings) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter("./" + filename)) {
            for(Object string : strings) {
                printWriter.println(string);
            }
        }
    }

    public static String[] getContent(String filename) throws IOException, InvalidInputFileException {
        List<String> stringList = new LinkedList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String tempString;
            while (null != (tempString = bufferedReader.readLine())) {
                if (!stringList.add(tempString)) {
                    throw new InvalidInputFileException("Can not load all the lines from "
                            + filename + " to RAM");
                }
            }
        }

        String[] strings = new String[stringList.size()];
        strings = stringList.toArray(strings);
        return strings;
    }

}
