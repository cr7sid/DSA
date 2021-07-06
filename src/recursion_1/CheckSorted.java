package recursion_1;

import java.util.Scanner;

public class CheckSorted {
	
	public static boolean checkSorted(int[] input) {
		if(input.length <= 1) {
			return true;
		}
		if(input[0] > input[1]) {
			return false;
		}
		int[] smaller = new int[input.length - 1];
		for(int i = 1; i < input.length; i++) {
			smaller[i - 1] = input[i];
		}
		return checkSorted(smaller);
	}
	
	private static boolean checkSorted_2(int[] input, int startIndex) {
		if(startIndex >= input.length - 1) {
			return true;
		}
		if(input[startIndex] > input[startIndex + 1]) {
			return false;
		}
		return checkSorted_2(input, startIndex + 1);
	}
	
	public static boolean checkSorted_2(int[] input) {
		return checkSorted_2(input, 0);
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		boolean ans = checkSorted_2(arr);
		System.out.print(ans);
		sc.close();
	}

}
