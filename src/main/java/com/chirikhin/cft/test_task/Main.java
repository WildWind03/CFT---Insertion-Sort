package com.chirikhin.cft.test_task;

import com.chirikhin.cft.algorithm.ISorter;
import com.chirikhin.cft.algorithm.SortAlgorithm;
import com.chirikhin.cft.algorithm.SorterFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SortConfiguration sortConfiguration = ArgumentParser.parseConfiguration(args);

        try {
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
                    break;

                case STRING:
                    iSorter.sort(strings, sortConfiguration.getSortType());
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
