package com.chirikhin.cft.algorithm;

public interface IComparator {
    <T, K extends Comparable<T>> int compareTo(K t1,T t2);
}
