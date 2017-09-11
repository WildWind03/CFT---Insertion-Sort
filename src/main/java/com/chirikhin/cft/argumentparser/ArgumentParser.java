package com.chirikhin.cft.argumentparser;

import com.chirikhin.cft.algorithm.SortDirection;

public class ArgumentParser {
    private static final String ASCENDING_SORT_TAG = "-a";
    private static final String DESCENDING_SORT_TAG = "-d";
    private static final String STRING_TAG = "-s";
    private static final String INTEGER_TAG = "-i";

    private final String[] args;

    public ArgumentParser(String[] args) {
        this.args = args;
    }

    public SortConfiguration parseConfiguration() {
        if (null == args) {
            throw new IllegalArgumentException("Args cannot be null");
        }

        if (args.length != 4) {
            throw new IllegalArgumentException("You must start the program with 4 arguments");
        }

        if (null == args[0] || null == args[1]
                || null == args[2] || null == args[3]) {
            throw new IllegalArgumentException("All the 4 arguments mustn't be null");
        }

        SortConfigurationBuilder sortConfigurationBuilder = new SortConfigurationBuilder();

        sortConfigurationBuilder.setInFilename(args[0]);
        sortConfigurationBuilder.setOutFilename(args[1]);
        switch (args[2]) {
            case STRING_TAG :
                sortConfigurationBuilder.setSortDataType(SortConfiguration.SortDataType.STRING);
                break;
            case INTEGER_TAG:
                sortConfigurationBuilder.setSortDataType(SortConfiguration.SortDataType.INTEGER);
                break;
            default:
                throw new IllegalArgumentException("Invalid source type: " + args[2]);
        }

        switch (args[3]) {
            case ASCENDING_SORT_TAG :
                sortConfigurationBuilder.setSortDirection(SortDirection.ASCENDING);
                break;
            case DESCENDING_SORT_TAG:
                sortConfigurationBuilder.setSortDirection(SortDirection.DESCENDING);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort type: " + args[3]);
        }

        return sortConfigurationBuilder.createSortConfiguration();
    }
}
