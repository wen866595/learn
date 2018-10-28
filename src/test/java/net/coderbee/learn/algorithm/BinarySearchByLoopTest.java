package net.coderbee.learn.algorithm;

import org.junit.Test;
import static net.coderbee.learn.algorithm.BinarySearchByLoop.*;
import static org.junit.Assert.*;

public class BinarySearchByLoopTest {
    int[] array = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};

    @Test
    public void testSearch() {
        assertEquals(0, search(array, 1));
        assertEquals(9, search(array, 18));
    }

    @Test
    public void testFindFirst() {
        assertEquals(5, findFirst(array, 8));
        assertEquals(2, findFirst(array, 4));
    }

    @Test
    public void testFindFirstGreatEquals() {
        assertEquals(5, findFirstGreatEquals(array, 8));
        assertEquals(8, findFirstGreatEquals(array, 9));
        assertEquals(1, findFirstGreatEquals(array, 3));
    }

}
