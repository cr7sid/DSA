package recursion_1;

import java.util.Scanner;

/*Write a program to find x to the power n (i.e. x^n). Take x and n from the user. 
You need to return the answer.Do this recursively.*/

public class XToPowerN {
	
	public static long xToN(int x, int n) {
		if(n == 0) {
			return 1;
		}
		if(x == 0) {
			return 0;
		}
		return x * xToN(x, n - 1);
	}
	
	public static void main(String[] args) {
		int x, n;
		Scanner scanner = new Scanner(System.in);
		x = scanner.nextInt();
		n = scanner.nextInt();
		long ans = xToN(x, n);
		System.out.println(ans);
		scanner.close();
	}
	
}
