package com.chirikhin.cft.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSorterTest {
    @Test
    public void sortStringsTestAscending() throws Exception {
        InsertionSorter insertionSorter = new InsertionSorter();
        String[] arr = new String[] {"a", "d", "b", "123", null};
        insertionSorter.sort(arr, SortDirection.ASCENDING);
        Assert.assertArrayEquals(arr, new String[] {null, "123", "a", "b", "d"});
    }

    @Test
    public void sortStringTestDescending() throws Exception {
        InsertionSorter insertionSorter = new InsertionSorter();
        String[] arr = new String[] {"a", "d", "b", "123", null};
        insertionSorter.sort(arr, SortDirection.DESCENDING);
        Assert.assertArrayEquals(arr, new String[] {"d", "b", "a", "123", null});
    }

    @Test
    public void sortIntegersTest() throws Exception {
        InsertionSorter insertionSorter = new InsertionSorter();
        Integer[] arr = new Integer[] {45, 23, 56, 123, null};
        insertionSorter.sort(arr, SortDirection.ASCENDING);
        Assert.assertArrayEquals(arr, new Integer[] {null, 23, 45, 56, 123});
    }

}