package net.coderbee.learn.datastructure;

import org.junit.Test;

public class TestArrayBasedBigHeap {

    @Test
    public void test() {

        int[] arr = new int[]{2, 1, 8, 7, 6, 5, 9, 15, 13, 16, 21, 17, 33};

        int maxCount = arr.length;
        ArrayBasedBigHeap heap = new ArrayBasedBigHeap(maxCount);
        for(int i : arr) {
            heap.add(i);
        }

        System.out.println(heap.toString());

        int pop = heap.pop();
        System.out.println("pop:" + pop);

        System.out.println(heap);

    }

}
