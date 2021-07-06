package recursion_1;

import java.util.Scanner;

public class NumOfDigits {

	public static int numOfDigits(int n) {
		if(n == 0) {
			return 0;
		}
		return (1 + numOfDigits(n / 10));
	}
	
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int ans = numOfDigits(n);
		System.out.print(ans);
		sc.close();
	}
	
}
