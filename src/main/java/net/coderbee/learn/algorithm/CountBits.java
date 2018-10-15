package net.coderbee.learn.algorithm;

public class CountBits {
	
	public static int countByType(int n) {
		int cnt = 0;
		while(n != 0) {
			if ((n & 1) != 0) {
				cnt++;
			}
			n = n >>> 1;
		}
		return cnt;
	}

	public static int countByTypeRecursive(int n) {
	    return countByTypeRecursiveInner(n, 0);
    }

    private static int countByTypeRecursiveInner(int n, int count) {
	    if (n == 0) {
	        return count;
        }

        return countByTypeRecursiveInner(n >>> 1, count + (n & 1));
    }

	public static int countByDeduct(int n) {
		int cnt = 0;
		while(n != 0) {
			cnt++;
			n = n & (n - 1);
		}
		return cnt;
	}

	public static int countByDeductRecursive(int n) {
        return countByDeductRecursiveInner(n, 0);
    }

    private static int countByDeductRecursiveInner(int n, int count) {
	    if (n == 0) {
	        return count;
        }
        return countByTypeRecursiveInner(n & (n - 1), 1 + count);
    }

    private static final byte[] table = new byte[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8};

    public static int countByLookUpTable(int n) {
        return table[n & 0xFF] + table[(n >>> 8) & 0xFF] + table[(n >>> 16) & 0xFF] + table[(n >>> 24) & 0xFF];
    }

}

