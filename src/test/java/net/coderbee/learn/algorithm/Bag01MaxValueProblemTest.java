package net.coderbee.learn.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class Bag01MaxValueProblemTest {
    int[] weight = new int[]{2, 3, 10};
    int[] value = new int[]{6, 2, 9};

    int[] weight1 = new int[]{2, 2, 6};
    int[] value1 = new int[]{5, 3, 7};

    @Test
    public void backtracing() {
        Assert.assertEquals(17, Bag01MaxValueProblem.backtracing(weight, value, 15));

        Assert.assertEquals(8, Bag01MaxValueProblem.backtracing(weight, value, 5));

        // 重量相同的情况下，选价值最大的
        Assert.assertEquals(5, Bag01MaxValueProblem.backtracing(weight1, value1, 2));
        Assert.assertEquals(12, Bag01MaxValueProblem.backtracing(weight1, value1, 8));
    }

    @Test
    public void dp() {
        Assert.assertEquals(17, Bag01MaxValueProblem.dp(weight, value, 15));

        Assert.assertEquals(8, Bag01MaxValueProblem.dp(weight, value, 5));

        // 重量相同的情况下，选价值最大的
        Assert.assertEquals(5, Bag01MaxValueProblem.dp(weight1, value1, 2));
        Assert.assertEquals(12, Bag01MaxValueProblem.dp(weight1, value1, 8));
    }

    @Test
    public void knapsack3() {
        Assert.assertEquals(17, Bag01MaxValueProblem.knapsack3(weight, value, weight.length, 15));

        Assert.assertEquals(8, Bag01MaxValueProblem.knapsack3(weight, value, weight.length, 5));

        Assert.assertEquals(5, Bag01MaxValueProblem.knapsack3(weight1, value1, weight.length, 2));
        Assert.assertEquals(12, Bag01MaxValueProblem.knapsack3(weight1, value1, weight.length, 8));
    }
}