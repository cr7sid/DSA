package recursion_1;

import java.util.Scanner;

public class FindAllX {

	private static void findAllX(int[] arr, int x, int startIndex) {
		if(arr[startIndex] == x) {
			System.out.print(startIndex + " ");
		}
		if(startIndex >= arr.length - 1) {
			return;
		}
		findAllX(arr, x, startIndex + 1);
	}
	
	public static void findLastX(int[] arr, int x) {
		findAllX(arr, x, 0);
	}
	
	public static void main(String[] args) {
		int n, x;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		findLastX(arr, x);
		sc.close();
	}

}
