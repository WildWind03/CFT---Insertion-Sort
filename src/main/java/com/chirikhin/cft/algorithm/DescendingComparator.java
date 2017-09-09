package com.chirikhin.cft.algorithm;

public class DescendingComparator implements MyComparator {
    @Override
    public <T, K extends Comparable<T>> int compareTo(K o1, T o2) {
        if (null == o2) {
            if (null == o1) {
                return 0;
            } else {
                return -1;
            }
        }

        if (null == o1) {
            return 1;
        }

        return -o1.compareTo(o2);
    }
}
