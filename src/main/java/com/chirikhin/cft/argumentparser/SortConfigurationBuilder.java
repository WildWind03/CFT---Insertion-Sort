package com.chirikhin.cft.argumentparser;

import com.chirikhin.cft.algorithm.SortType;
import com.chirikhin.cft.algorithm.SourceType;

public class SortConfigurationBuilder {
    private SourceType sourceType;
    private SortType sortType;
    private String inFilename;
    private String outFilename;

    public SortConfigurationBuilder setSourceType(SourceType sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    public SortConfigurationBuilder setSortType(SortType sortType) {
        this.sortType = sortType;
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
        return new SortConfiguration(sourceType, sortType, inFilename, outFilename);
    }
}