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

    public IComparator createComparator(SortDirection sortDirection) {
        if (null == sortDirection) {
            throw new IllegalArgumentException("It's impossible to create comparator with null sort type");
        }

        switch (sortDirection) {
            case ASCENDING:
                return new AscendingComparator();
            case DESCENDING:
                return new DescendingComparator();
            default:
                throw new IllegalArgumentException("It's impossible to create comparator for such sort type: "
                        + sortDirection.name());
        }
    }
}
