package com.chirikhin.cft.algorithm;

public interface ISorter {
    <T extends Comparable<T>> void sort(T[] data, SortDirection sortDirection);
}
