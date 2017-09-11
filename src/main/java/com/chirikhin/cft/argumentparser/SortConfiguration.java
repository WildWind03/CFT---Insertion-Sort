package com.chirikhin.cft.argumentparser;

import com.chirikhin.cft.algorithm.SortDirection;

public class SortConfiguration {

    public enum SortDataType {
        INTEGER, STRING
    }

    private final SortDirection sortDirection;
    private final SortDataType sortDataType;
    private final String inFilename;
    private final String outFilename;

    public SortConfiguration (SortDataType sortDataType, SortDirection sortDirection, String inFilename, String outFilename) {
        if (null == sortDataType || null == sortDirection || null == inFilename || null == outFilename) {
            throw new IllegalArgumentException("All the fields of sort configuration instance must be not null");
        }

        this.sortDirection = sortDirection;
        this.sortDataType = sortDataType;
        this.inFilename = inFilename;
        this.outFilename = outFilename;
    }



    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public SortDataType getSortDataType() {
        return sortDataType;
    }

    public String getInFilename() {
        return inFilename;
    }

    public String getOutFilename() {
        return outFilename;
    }
}
