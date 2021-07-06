package recursion_1;

import java.util.Scanner;

public class CheckX {

	public static boolean checkX(int[] input, int x) {
		if(input[0] == x) {
			return true;
		}
		if(input.length <= 1) {
			return false;
		}
		int[] smaller = new int[input.length - 1];
		for(int i = 1; i < input.length; i++) {
			smaller[i - 1] = input[i];
		}
		return checkX(smaller, x);
	}
	
	public static boolean checkX_2(int[] input, int startIndex, int x) {
		if(startIndex >= input.length) {
			return false;
		}
		if(input[startIndex] == x) {
			return true;
		}
		startIndex++;
		return checkX_2(input, startIndex, x);
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
		boolean ans = checkX_2(arr, 0, x);
		System.out.print(ans);
		sc.close();
	}

}
