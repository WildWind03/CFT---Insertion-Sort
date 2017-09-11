package com.chirikhin.cft.filesorter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class InputFileReader {

    private final String filename;

    public InputFileReader(String filename) {
        this.filename = filename;
    }

    public String[] getContent() throws IOException, InvalidInputFileException {
        List<String> stringList = new LinkedList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String tempString;
            while (null != (tempString = bufferedReader.readLine())) {
                if (!stringList.add(tempString)) {
                    throw new InvalidInputFileException("Can not load all the lines from ".concat(filename).concat(" to RAM"));
                }
            }
        }

        String[] strings = new String[stringList.size()];
        strings = stringList.toArray(strings);
        return strings;
    }
}
