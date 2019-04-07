package net.coderbee.learn.algorithm;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSumOfSubArrayTest {

    @Test
    public void maxSumOfArray() {
        assert0(11, new int[]{-3, -2, 1, -4, 5, 6, -1});
        assert0(8, new int[]{1, -2, 3, 5, -3, 2});
        assert0(9, new int[]{0, -2, 3, 5, -1, 2});
        assert0(-2, new int[]{-9, -2, -3, -5, -3});
    }

    private void assert0(int excepted, int[] array) {
        int maxSum = MaxSumOfSubArray.maxSumOfArray(array);
        Assert.assertEquals(excepted, maxSum);
    }
}