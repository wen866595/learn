package net.coderbee.learn.algorithm;

/**
 * 通过循环的方式实现二分查找。
 */
public class BinarySearchByLoop {

    public static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int findFirst(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (array[mid] == target) {
                foundIndex = mid;
                high = mid - 1;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return foundIndex;
    }

    public static int findFirstGreatEquals(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            if (array[mid] >= target) {
                foundIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return foundIndex;
    }

}
