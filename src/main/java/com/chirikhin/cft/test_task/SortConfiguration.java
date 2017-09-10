package com.chirikhin.cft.test_task;

import com.chirikhin.cft.algorithm.SortType;
import com.chirikhin.cft.algorithm.SourceType;

public class SortConfiguration {
    private final SortType sortType;
    private final SourceType sourceType;
    private final String inFilename;
    private final String outFilename;

    public SortConfiguration (SourceType sourceType, SortType sortType, String inFilename, String outFilename) {
        if (null == sourceType || null == sortType || null == inFilename || null == outFilename) {
            throw new IllegalArgumentException("All the fields of sort configuration instance must be not null");
        }

        this.sortType = sortType;
        this.sourceType = sourceType;
        this.inFilename = inFilename;
        this.outFilename = outFilename;
    }



    public SortType getSortType() {
        return sortType;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public String getInFilename() {
        return inFilename;
    }

    public String getOutFilename() {
        return outFilename;
    }
}
