package net.coderbee.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertSortTest extends SortTestBase {

    @Test
    public void testInsertSort() {
        int[] array = getArray();
        InsertSort.insertSort(array);
        Assert.assertTrue(Arrays.equals(array, sortedArray));
    }

    @Test
    public void testInsertSortOptimized() {
        int[] array = getArray();
        InsertSort.insertSortOptimized(array);
        Assert.assertTrue(Arrays.equals(array, sortedArray));
    }

}
