package recursion_1;

import java.util.Scanner;

public class DigiSum {
	
	public static int sumOfDigits(int n) {
		if(n == 0) {
			return 0;
		}
		int sum = n % 10;
		return sum + sumOfDigits(n / 10);
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int ans = sumOfDigits(n);
		System.out.print(ans);
		sc.close();
	}

}
