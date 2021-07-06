package recursion_1;

import java.util.Scanner;

public class CountZeros {
	
	public static int countZeros(int n) {
		if(n == 0) {
			return 0;
		}
		int count = 0;
		if(n % 10 == 0) {
			count++;
		}
		return count + countZeros(n / 10);
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int ans = countZeros(n);
		System.out.print(ans);
		sc.close();
	}

}
