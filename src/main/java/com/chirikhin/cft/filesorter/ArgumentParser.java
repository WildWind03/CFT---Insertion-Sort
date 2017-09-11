package com.chirikhin.cft.filesorter;

import com.chirikhin.cft.algorithm.SortType;
import com.chirikhin.cft.algorithm.SourceType;

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
            throw new IllegalArgumentException("You must start the program with 4 arguments. Please, read readme file");
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
                sortConfigurationBuilder.setSourceType(SourceType.STRING);
                break;
            case INTEGER_TAG:
                sortConfigurationBuilder.setSourceType(SourceType.INTEGER);
                break;
            default:
                throw new IllegalArgumentException("Invalid source type: ".concat(args[2]));
        }

        switch (args[3]) {
            case ASCENDING_SORT_TAG :
                sortConfigurationBuilder.setSortType(SortType.ASCENDING);
                break;
            case DESCENDING_SORT_TAG:
                sortConfigurationBuilder.setSortType(SortType.DESCENDING);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort type: ".concat(args[3]));
        }

        return sortConfigurationBuilder.createSortConfiguration();
    }
}
