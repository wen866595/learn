package net.coderbee.learn.algorithm;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Bag01ProblemTest {
    int[] items = new int[] {2, 5, 10};

    @Test
    public void backtracing() {
        Assert.assertEquals(0, Bag01Problem.backtracing(items, 1));
        Assert.assertEquals(7, Bag01Problem.backtracing(items, 8));
        Assert.assertEquals(12, Bag01Problem.backtracing(items, 13));
        Assert.assertEquals(17, Bag01Problem.backtracing(items, 17));
    }

    @Test
    public void dp() {
        Assert.assertEquals(0, Bag01Problem.dp(items, 1));
        Assert.assertEquals(7, Bag01Problem.dp(items, 8));
        Assert.assertEquals(12, Bag01Problem.dp(items, 13));
        Assert.assertEquals(17, Bag01Problem.dp(items, 17));
    }
}