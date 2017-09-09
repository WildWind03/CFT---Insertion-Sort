package com.chirikhin.cft.algorithm;

public interface MyComparator {
    <T, K extends Comparable<T>> int compareTo(K t1,T t2);
}
