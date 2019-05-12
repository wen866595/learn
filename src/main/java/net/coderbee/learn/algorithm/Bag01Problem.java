package net.coderbee.learn.algorithm;

public class Bag01Problem {

    public static int backtracing(int[] weight, int bagMaxWeight) {
        return backtracing(weight, 0, 0, bagMaxWeight);
    }

    private static int backtracing(int[] weight, int index, int currentWeight, int bagMaxWeight) {
        if (index == weight.length || currentWeight == bagMaxWeight) {
            return currentWeight;
        }

        int exclude = backtracing(weight, index + 1, currentWeight, bagMaxWeight);
        if (currentWeight + weight[index] <= bagMaxWeight) {
            int include = backtracing(weight, index + 1, currentWeight + weight[index], bagMaxWeight);
            return Math.max(include, exclude);
        } else {
            return exclude;
        }
    }

    public static int dp(int[] weight, int bagMaxWeight) {
        boolean[] states = new boolean[bagMaxWeight + 1];
        states[0] = true;
        if (weight[0] <= bagMaxWeight) {
            states[weight[0]] = true;
        }
        for (int i = 1; i < weight.length; i++) {
            for (int w = bagMaxWeight - weight[i]; w >= 0; w--) {
                // w 的初始化和 循环判断条件保证了数组不会越界
                if (states[w] == true) {
                    states[w + weight[i]] = true;
                }
            }
        }

        for (int w = bagMaxWeight; w >= 0; w++) {
            if (states[w] == true) {
                return w;
            }
        }
        return 0;
    }
    
}
