package net.coderbee.learn.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

import static net.coderbee.learn.algorithm.BinarySearchByRecursive.*;

public class BinarySearchRecursiveTest {
    int[] array = new int[]{1, 3, 4, 7, 8};
    int[] array2 = new int[]{1, 3, 3, 3, 3, 4, 4, 7, 8};
    int[] array3 = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};

    @Test
    public void testBinarySearch() {
        assertEquals(1, search(array, 3));
        assertEquals(0, search(array, 1));
        assertEquals(-1, search(array, 2));
        assertEquals(4, search(array, 8));
    }

    @Test
    public void testFindFirst() {
        assertEquals(1, findFirstEquals(array2, 3));
        assertEquals(5, findFirstEquals(array2, 4));
        assertEquals(5, findFirstEquals(array3, 8));
    }

    @Test
    public void testFindLast() {
        assertEquals(7, findLastEquals(array3, 8));
    }

    @Test
    public void testFindFirstGreatEquals() {
        assertEquals(0, findFirstGreatEquals(array3, 1));
        assertEquals(5, findFirstGreatEquals(array3, 8));
        assertEquals(8, findFirstGreatEquals(array3, 9));
    }

    @Test
    public void testFindLastLessEquals() {
        assertEquals(7, findLastLessEquals(array3, 9));
        assertEquals(7, findLastLessEquals(array3, 8));
    }

}
