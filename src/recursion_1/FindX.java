package recursion_1;

import java.util.Scanner;

public class FindX {
	
	private static int findX(int[] arr, int x, int startIndex) {
		if(arr[startIndex] == x) {
			return startIndex;
		}
		if(startIndex >= arr.length - 1) {
			return -1;
		}
		return findX(arr, x, startIndex + 1);
	}
	
	public static int findX(int[] arr, int x) {
		return findX(arr, x, 0);
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
		int ans = findX(arr, x);
		System.out.print(ans);
		sc.close();
	}

}
