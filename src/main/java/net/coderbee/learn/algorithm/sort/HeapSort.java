package net.coderbee.learn.algorithm.sort;

public class HeapSort {

    /**
     * 堆排序
     *
     * @param array 要排序的数组
     * @param n     数组里元素个数
     */
    public static void sort(int[] array, int n) {
        buildHeap(array, n);
        sortInner(array, n);
    }

    private static void sortInner(int[] array, int n) {
        for (int j = n; j > 1; j--) {
            swap(array, 1, j);
            heapifyDown(array, j - 1, 1);
        }
    }

    private static void buildHeap(int[] array, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapifyDown(array, n, i);
        }
    }

    private static void heapifyDown(int[] array, int n, int i) {
        if (i * 2 <= n) {
            // 存在子节点
            if (i * 2 + 1 <= n && array[i * 2] < array[i * 2 + 1] && array[i] < array[i * 2 + 1]) {
                // 右子树也存在，且右子树比左子树、父节点大
                swap(array, i, i * 2 + 1);
                heapifyDown(array, n, i * 2 + 1);
            } else if (array[i] < array[i * 2]) {
                // 父节点比左子树小
                swap(array, i, i * 2);
                heapifyDown(array, n, i * 2);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
