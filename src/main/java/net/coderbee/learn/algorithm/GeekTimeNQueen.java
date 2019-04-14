package net.coderbee.learn.algorithm;

public class GeekTimeNQueen {
    private int num;
    private int[] arr;
    private int resultCount;

    public GeekTimeNQueen(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n < 1");
        }
        num = n;
        arr = new int[num];
    }

    public void play(){
        run(0);
    }

    private void run(int row) {
        if (row == num) {
            resultCount++;
            print();
            return;
        }

        for (int c = 0; c < num; c++) {
            if(isValid(row, c)) {
                arr[row] = c;
                run(row + 1);
            }
        }
    }

    private boolean isValid(int row, int col) {
        int leftDown = col - 1;
        int rightDown = col + 1;

        for(int r = row - 1; r >= 0; r--) {
            if (arr[r] == col) { // 检测垂直列
                return false;
            }

            if (leftDown >= 0 && arr[r] == leftDown) { // 检测左下
                return false;
            }

            if (rightDown < num && arr[r] == rightDown) { // 检测右下
                return false;
            }

            leftDown--;
            rightDown++;
        }

        return true;
    }

    private void print() {
        System.out.println("第 " + resultCount + " 个解");
        for (int r = 0; r < num; r++) {
            for (int c = 0; c < num; c++) {
                if (arr[r] == c) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
