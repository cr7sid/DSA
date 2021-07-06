package recursion_1;

import java.util.Scanner;

public class RecursiveMulti {
	
	private static int multiply(int m, int n) {
		if(m == 1) {
			return n;
		}
		return n + multiply(m - 1, n);
	}
	
	public static int callMultiply(int m, int n) {
		if(m == 0 || n == 0) {
			return 0;
		}
		if(m > n) {
			int temp = m;
			m = n;
			n = temp;
		}
		return multiply(m, n);
	}
	
	public static void main(String[] args) {
		int m, n;
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		int ans = callMultiply(m, n);
		System.out.print(ans);
		sc.close();
	}

}
