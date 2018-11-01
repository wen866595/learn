package net.coderbee.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSortTest extends SortTestBase {

    @Test
    public void testQuickSort() {
        int[] array = getArray();
        QuickSort.quickSort(array);
        Assert.assertTrue(Arrays.equals(array, sortedArray));

        int[] array2 = getArray2();
        QuickSort.quickSort(array2);
        Assert.assertTrue(Arrays.equals(array2, sortedArray2));
    }

}
