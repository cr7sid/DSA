package recursion_1;

import java.util.Scanner;

public class PrintNums {
	
	public static void printNum(int n) {
		if(n == 0) {
			return;
		}
		printNum(n - 1);
		System.out.print(n + " ");
	}
	
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		printNum(n);
		sc.close();
	}

}
