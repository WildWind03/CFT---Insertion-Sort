package com.chirikhin.cft.algorithm;

public class InsertionSorter implements ISorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] data, SortType sortType) {
        if (null == data) {
            return;
        }

        if (0 == data.length || 1 == data.length) {
            return;
        }

        MyComparator comparator = ComparatorFactory.createComparator(sortType);

        synchronized (data) {
            T tmp;

            for (int i = 0; i < data.length; ++i) {
                tmp = data[i];

                int j;
                for (j = i - 1; j >= 0 && (comparator.compareTo(data[j], tmp) > 0); --j) {
                    data[j + 1] = data[j];
                }

                data[j + 1] = tmp;
            }
        }
    }
}
