package net.coderbee.learn.algorithm;

public class CountBits {
	
	public static int countByType(int n) {
		int cnt = 0;
		while(n != 0) {
			if (n & 1 != 0) {
				cnt++;
			}
			n = n >>> 1;
		}
		return n;
	}

	public static int countByDeduct(int n) {
		int cnt = 0;
		while(n != 0) {
			cnt++;
			n = n & (n - 1);
		}
		return cnt;

	}
	

	private static byte[] table = new byte[]{};
	public static int countByLookUpTable(int n) {
		
	}

}

