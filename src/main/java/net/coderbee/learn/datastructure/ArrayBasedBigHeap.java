package net.coderbee.learn.datastructure;

public class ArrayBasedBigHeap {
    private final int[] array;
    private final int maxElements;
    private int count = 0;

    public ArrayBasedBigHeap(int maxElements) {
        if (maxElements <= 0) {
            throw new IllegalArgumentException("maxElements <= 0");
        }
        this.maxElements = maxElements;
        this.array = new int[maxElements + 1];
    }

    public boolean add(int newElement) {
        if (count >= maxElements) {
            return false;
        }

        array[++count] = newElement;

        heapifyUp();

        return true;
    }

    private void heapifyUp() {
        int index = count;
        while (index > 1 && array[index] > array[index / 2]) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }

        int t = array[1];
        array[1] = array[count--];
        heapifyDown(1);

        return t;
    }

    private void heapifyDown(int i) {
        if (i * 2 <= count) {
            // 存在子节点
            if (i * 2 + 1 <= count && array[i * 2] < array[i * 2 + 1] && array[i] < array[i * 2 + 1]) {
                // 右子树也存在，且右子树比左子树、父节点大
                swap(i, i * 2 + 1);
                heapifyDown(i * 2 + 1);
            } else if (array[i] < array[i * 2]){
                // 父节点比左子树小
                swap(i, i * 2);
                heapifyDown(i * 2);
            }
        }
    }


    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 1; i <= count; i++) {
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }
            sb.append(array[i]);
        }

        return sb.toString();
    }
}
