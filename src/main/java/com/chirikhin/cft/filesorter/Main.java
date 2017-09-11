package com.chirikhin.cft.filesorter;

import com.chirikhin.cft.algorithm.ISorter;
import com.chirikhin.cft.algorithm.SortAlgorithm;
import com.chirikhin.cft.algorithm.SorterFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            ArgumentParser argumentParser = new ArgumentParser(args);
            SortConfiguration sortConfiguration = argumentParser.parseConfiguration();

            InputFileReader inputFileReader = new InputFileReader(sortConfiguration.getInFilename());
            String[] strings = inputFileReader.getContent();
            ISorter iSorter = SorterFactory
                    .getInstance()
                    .createSorter(SortAlgorithm.INSERTION);

            OutputFileWriter outputFileWriter = new OutputFileWriter(sortConfiguration.getOutFilename());
            switch (sortConfiguration.getSourceType()) {
                case INTEGER:
                    Integer[] integers = Arrays
                            .stream(strings)
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .toArray(Integer[]::new);

                    iSorter.sort(integers, sortConfiguration.getSortType());
                    outputFileWriter.write(integers);
                    break;

                case STRING:
                    iSorter.sort(strings, sortConfiguration.getSortType());
                    outputFileWriter.write(strings);
                    break;

                default:
                    throw new IllegalArgumentException("Inappropriate source type "
                            .concat(sortConfiguration.getSourceType().name()));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
