package net.coderbee.learn.algorithm;

/**
 * 二分查找的变形算法（比如查找第一个等于给定值的算法）的关键在于：<br/>
 * 找到一个满足条件的结果后，还得继续在可能存在满足条件的区域继续查找，<br/>
 * 而继续查找不一定能找到满足条件的，所以必须把当前找到的结果存起来；<br/>
 * 如果找不到就返回当前的结果，否则返回继续查找的结果。<br/>
 * 初始化的查找结果是没有找到的。
 */
public class BinarySearchByRecursive {

    public static int findFirstGreatEquals(int[] array, int target) {
        return findFirstGreatEqualsInner(array, target, 0, array.length - 1, -1);
    }

    private static int findFirstGreatEqualsInner(int[] array, int target, int low, int high, int foundIndex) {
        if (low > high) {
            return foundIndex;
        }

        int mid = low + ((high - low) >>> 1);
        if (array[mid] >= target) {
            return findFirstGreatEqualsInner(array, target, low, mid - 1, mid);
        } else {
            return findFirstGreatEqualsInner(array, target, mid + 1, high, foundIndex);
        }
    }

    public static int findLastLessEquals(int[] array, int target) {
        return findLastLessEqualsInner(array, target, 0, array.length - 1, -1);
    }

    private static int findLastLessEqualsInner(int[] array, int target, int low, int high, int foundIndex) {
        if (low > high) {
            return foundIndex;
        }

        int mid = low + ((high - low) >>> 1);
        if (array[mid] <= target) {
            return findLastLessEqualsInner(array, target, mid + 1, high, mid);
        } else {
            return findLastLessEqualsInner(array, target, low, mid - 1, foundIndex);
        }
    }

    public static int findLastEquals(int[] array, int target) {
        return findLastEqualsInner(array, target, 0, array.length - 1, -1);
    }

    private static int findLastEqualsInner(int[] array, int target, int low, int high, int foundIndex) {
        if (low > high) {
            return foundIndex;
        }

        int mid = low + ((high - low) >>> 1);
        if (array[mid] == target) {
            return findLastEqualsInner(array, target, mid + 1, high, mid);
        } else if (array[mid] > target) {
            return findLastEqualsInner(array, target, low, mid - 1, foundIndex);
        } else {
            return findLastEqualsInner(array, target, mid + 1, high, foundIndex);
        }
    }

    public static int findFirstEquals(int[] array, int target) {
        return findFirstEqualsInner(array, target, 0, array.length - 1, -1);
    }

    private static int findFirstEqualsInner(int[] array, int target, int low, int high, int foundIndex) {
        if (low > high) {
            return foundIndex;
        }

        int mid = low + ((high - low) >>> 1);
        if (array[mid] == target) {
            return findFirstEqualsInner(array, target, low, mid - 1, mid);
        } else if (array[mid] > target) {
            return findFirstEqualsInner(array, target, low, mid - 1, foundIndex);
        } else {
            return findFirstEqualsInner(array, target, mid + 1, high, foundIndex);
        }
    }

    public static int search(int[] array, int target) {
        return searchInner(array, target, 0, array.length - 1);
    }

    private static int searchInner(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) >>> 1);
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return searchInner(array, target, low, mid - 1);
        } else {
            return searchInner(array, target, mid + 1, high);
        }
    }

}
