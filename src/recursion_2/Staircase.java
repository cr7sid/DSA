package recursion_2;

import java.util.Scanner;

public class Staircase {
	
	public static int staircase(int n, int count) {
		if(n <= 0) {
			count++;
			return count;
		}
		int ans = 0;
		if(n >= 3)
			ans += staircase(n - 3, count);
		if(n >= 2)
			ans += staircase(n - 2, count);
		ans += staircase(n - 1, count);
		return ans;		
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.print(staircase(n, 0));
		sc.close();
	}

}
