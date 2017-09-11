package com.chirikhin.cft.argumentparser;

import com.chirikhin.cft.algorithm.SortDirection;

public class SortConfigurationBuilder {
    private SortConfiguration.SortDataType sortDataType;
    private SortDirection sortDirection;
    private String inFilename;
    private String outFilename;

    public SortConfigurationBuilder setSortDataType(SortConfiguration.SortDataType sortDataType) {
        this.sortDataType = sortDataType;
        return this;
    }

    public SortConfigurationBuilder setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
        return this;
    }

    public SortConfigurationBuilder setInFilename(String inFilename) {
        this.inFilename = inFilename;
        return this;
    }

    public SortConfigurationBuilder setOutFilename(String outFilename) {
        this.outFilename = outFilename;
        return this;
    }

    public SortConfiguration createSortConfiguration() {
        return new SortConfiguration(sortDataType, sortDirection, inFilename, outFilename);
    }
}