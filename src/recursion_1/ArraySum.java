package recursion_1;

import java.util.Scanner;

public class ArraySum {
	
	public static int sum(int[] arr) {
		int n = arr.length;
		if(n <= 1) {
			return arr[0];
		}
		int[] smallerOne = new int[n - 1];
		
		for(int i = 1; i < n; i++) {
			smallerOne[i - 1] = arr[i];
		}
		
		return arr[0] + sum(smallerOne);
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = sum(arr);
		System.out.print(ans);
		sc.close();
	}

}
