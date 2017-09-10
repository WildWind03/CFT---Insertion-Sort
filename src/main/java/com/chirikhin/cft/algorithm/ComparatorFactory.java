package com.chirikhin.cft.algorithm;

public class ComparatorFactory {
    private ComparatorFactory() {

    }

    public static IComparator createComparator(SortType sortType) {
        if (null == sortType) {
            throw new IllegalArgumentException("Sort Type cannot be null");
        }

        switch (sortType) {
            case ASCENDING:
                return new AscendingComparator();
            case DESCENDING:
                return new DescendingComparator();
            default:
                throw new IllegalArgumentException("Error! Reached unreachable case!");
        }
    }
}
