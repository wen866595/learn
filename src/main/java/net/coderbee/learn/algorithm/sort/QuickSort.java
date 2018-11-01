package net.coderbee.learn.algorithm.sort;

public class QuickSort {

    public static void quickSort(int[] array) {
        quickSortInner(array, 0, array.length - 1);
    }

    private static void quickSortInner(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int partitionIndex = partition(array, low, high);
        quickSortInner(array, low, partitionIndex - 1);
        quickSortInner(array, partitionIndex + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int p = low;

        // 下标在 p 左侧的都是小于 pivo 的，右侧都是大于等于 pivot 。
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swap(array, j, p);
                p++;
            }
        }

        // p 处的元素可能大于 pivot ，也就是此元素的值可能不是其最终的位置，所以需要交换 pivot 到此。
        swap(array, p, high);
        return p;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
