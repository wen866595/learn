package net.coderbee.learn.algorithm;

import java.util.Arrays;

public class NQueen {
    private final int[][] arr;
    private final int num;
    private int resultCount = 0; // 解空间数量

    public NQueen(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n < 1");
        }
        num = n;
        arr = new int[num][num];
    }

    public void play() {
        // 从第 0 行开始摆放
        run(0);
    }

    /**
     * 以 行 为步骤，逐行放置棋子。
     *
     * @param row
     */
    private void run(int row) {
        if (row == 8) {
            resultCount++;
            print();
            return;
        }

        for (int c = 0; c < num; c++) {
            // 对于给定的行，遍历所有的列，如果行、列组合满足则进入下一行。
            if (isValid(row, c)) {
                arr[row][c] = 1;
                run(row + 1);

                // 回溯到当前行，继续下一列
                arr[row][c] = 0;
            }
        }
    }

    private boolean isValid(int row, int col) {
        int leftDown = col - 1;
        int rightDown = col + 1;

        for (int r = row - 1; r >= 0; r--) {
            if (arr[r][col] == 1) { // 检测列上是否有
                return false;
            }

            if (leftDown >= 0 && arr[r][leftDown] == 1) { // 检测左下对角线
                return false;
            }

            if (rightDown < num && arr[r][rightDown] == 1) { // 检测右下对角线
                return false;
            }

            leftDown--;
            rightDown++;
        }

        return true;
    }

    private void print() {
        System.out.println("第 " + resultCount + " 个解");
        for (int r = 0; r < arr.length; r++) {
            String s = Arrays.toString(arr[r]);
            System.out.println(s.substring(1, s.length() - 1).replaceAll(",", ""));
        }
    }

}
