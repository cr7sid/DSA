package recursion_1;

import java.util.Scanner;

public class FindLastX {

	private static int findLastX(int[] arr, int x, int startIndex, int found) {
		if(arr[startIndex] == x) {
			found = startIndex;
		}
		if(startIndex >= arr.length - 1) {
			return found;
		}
		return findLastX(arr, x, startIndex + 1, found);
	}
	
	public static int findLastX(int[] arr, int x) {
		return findLastX(arr, x, 0, -1);
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
		int ans = findLastX(arr, x);
		System.out.print(ans);
		sc.close();
	}

}
