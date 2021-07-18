package recursion_2;

import java.util.Scanner;

public class Staircase {
	
	public static int staircase(int n, int count) {
		return 1;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.print(staircase(n, 0));
		sc.close();
	}

}
