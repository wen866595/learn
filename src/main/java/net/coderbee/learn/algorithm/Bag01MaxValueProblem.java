package net.coderbee.learn.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Bag01MaxValueProblem {

    /**
     * 对于一组不同重量、不同价值、不可分割的物品，选择将某些物品装入背包，<br/>
     * 在满足最大重量限制的前提下，背包中可装入物品的总价值最大是多少？
     *
     * @param weight       物品重量
     * @param values       物品价值
     * @param bagMaxWeight 背包最大重量
     * @return 装入背包的物品的最大价值
     */
    public static int backtracing(int[] weight, int[] values, int bagMaxWeight) {
        return backtracing(weight, values, bagMaxWeight, 0, 0, 0);
    }

    private static int backtracing(int[] weight, int[] values, int bagMaxWeight, int index, int currentWeight, int currentValue) {
        if (index == weight.length || currentWeight > bagMaxWeight) {
            return currentValue;
        }

        int exclude = backtracing(weight, values, bagMaxWeight, index + 1, currentWeight, currentValue);
        if (currentWeight + weight[index] <= bagMaxWeight) {
            int include = backtracing(weight, values, bagMaxWeight, index + 1, currentWeight + weight[index], currentValue + values[index]);
            return Math.max(include, exclude);
        } else {
            return exclude;
        }
    }

    public static int dp(int[] weight, int[] value, int bagMaxWeight) {
        int[] v = new int[bagMaxWeight + 1];
        for (int i = 0; i <= bagMaxWeight; i++) {
            v[i] = -1;
        }

        v[0] = 0;
        if (weight[0] <= bagMaxWeight) {
            v[weight[0]] = value[0];
        }

        for (int i = 1; i < weight.length; i++) { // 遍历物品
            for (int j = bagMaxWeight - weight[i]; j >= 0; j--) { // 考察重量，从大往下是防止覆盖
                int nextValue = v[j] + value[i];
                int nextWeightIndex = j + weight[i];
                if (v[j] >= 0 && nextValue > v[nextWeightIndex]) { //
                    v[nextWeightIndex] = nextValue;
                }
            }
        }

        int mv = 0;
        for (int i = 0; i <= bagMaxWeight; i++) {
            if (v[i] > mv) {
                mv = v[i];
            }
        }
        return mv;
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                states[i][i] = -1;
            }
        }

        states[0][0] = 0;
        states[0][weight[0]] = value[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i - 1][j];
                }
            }

            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }

        int mv = -1;
        for (int j = 0; j <= w; j++) {
            if (states[n - 1][j] > mv) {
                mv = states[n - 1][j];
            }
        }
        return mv;
    }

}
