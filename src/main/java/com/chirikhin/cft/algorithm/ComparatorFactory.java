package com.chirikhin.cft.algorithm;

public class ComparatorFactory {

    public static class ComparatorFactoryHolder {
        private static final ComparatorFactory instance = new ComparatorFactory();
    }

    private ComparatorFactory() {

    }

    public static ComparatorFactory getInstance() {
        return ComparatorFactoryHolder.instance;
    }

    public IComparator createComparator(SortType sortType) {
        if (null == sortType) {
            throw new IllegalArgumentException("sortType cannot be null");
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
