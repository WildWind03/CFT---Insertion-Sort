package com.chirikhin.cft.algorithm;

public class SorterFactory {

    public static class SorterFactoryHolder {
        private static final SorterFactory instance = new SorterFactory();
    }

    private SorterFactory() {

    }

    public static SorterFactory getInstance() {
        return SorterFactoryHolder.instance;
    }

    public ISorter createSorter(SortAlgorithm sortAlgorithm) {
        if (null == sortAlgorithm) {
            throw new IllegalArgumentException("A sort algorithm can not be null");
        }

        switch (sortAlgorithm) {
            case INSERTION:
                return new InsertionSorter();
            default:
                throw new IllegalArgumentException("Error! Reached unreachable case");
        }
    }
}
