package com.chirikhin.cft.test_task;

import com.chirikhin.cft.algorithm.ISorter;
import com.chirikhin.cft.algorithm.SortAlgorithm;
import com.chirikhin.cft.algorithm.SorterFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            SortConfiguration sortConfiguration = ArgumentParser.parseConfiguration(args);

            String[] strings = InputFileReader.getContent(sortConfiguration.getInFilename());
            ISorter iSorter = SorterFactory.createSorter(SortAlgorithm.INSERTION);
            switch (sortConfiguration.getSourceType()) {
                case INTEGER:
                    Integer[] integers = Arrays
                            .stream(strings)
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .toArray(Integer[]::new);

                    iSorter.sort(integers, sortConfiguration.getSortType());
                    OutputFileWriter.write(sortConfiguration.getOutFilename(), integers);
                    break;

                case STRING:
                    iSorter.sort(strings, sortConfiguration.getSortType());
                    OutputFileWriter.write(sortConfiguration.getOutFilename(), strings);
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
