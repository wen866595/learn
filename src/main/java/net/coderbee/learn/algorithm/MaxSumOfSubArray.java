package net.coderbee.learn.algorithm;

/**
 * 《编程之美》2.14 求一维数组的子数组之和的最大值。<br/>
 * 分析：<br/>
 * 对于求和的最大值，负数是没有正向作用的。<br/>
 * 对于一个元素 N，如果之前元素的累加之和 tmpSum 是一个负数，应该舍弃 tmpSum，从 N 重新开始累加。<br/>
 */
public class MaxSumOfSubArray {

    public static int maxSumOfArray(int[] array) {
        int sum = array[0];
        int tmpSum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (tmpSum <= 0) {
                tmpSum = array[i];
            } else {
                tmpSum += array[i];
            }

            if (tmpSum > sum) {
                sum = tmpSum;
            }
        }

        return sum;
    }

}
