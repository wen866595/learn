package net.coderbee.learn.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest extends SortTestBase {

    @Test
    public void test() {
        int[] array = getArray();
        heapSort(array);
        Assert.assertTrue(Arrays.equals(array, sortedArray));

        int[] array2 = getArray2();
        heapSort(array2);
        Assert.assertTrue(Arrays.equals(array2, sortedArray2));
    }

    private void heapSort(int[] array) {
        int[] tmpArray = new int[array.length + 1];
        System.arraycopy(array, 0, tmpArray, 1, array.length);

        HeapSort.sort(tmpArray, array.length);
        System.arraycopy(tmpArray, 1, array, 0, array.length);
    }

}
