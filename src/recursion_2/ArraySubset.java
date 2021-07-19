package recursion_2;

import java.util.Scanner;

public class ArraySubset {
	
	public static int[][] arraySubset(int[] arr) {
		return arraySubset(arr, 0);
	}

	private static int[][] arraySubset(int[] arr, int sI) {
		if(sI >= arr.length) {
			int a[][] = {{}};
			return a;
		}
		int[][] smallAns = arraySubset(arr, sI + 1);
		int[][] ans = new int[smallAns.length * 2][];
		
		for(int i = 0; i < smallAns.length; i++) {
			ans[i] = new int[smallAns[i].length];
			for(int j = 0; j < smallAns[i].length; j++) {
				ans[i][j] = smallAns[i][j];
			}
		}
		for(int i = smallAns.length; i < ans.length; i++) {
			ans[i] = new int[smallAns[i - smallAns.length].length + 1];
			ans[i][0] = arr[sI];
			for(int j = 1; j < ans[i].length; j++) {
				ans[i][j] = smallAns[i - smallAns.length][j - 1];
			}
		}
		return ans;
	}
	
	private static void printSubsets(int[] arr, int sI, int[] output) {
		if(sI >= arr.length) {
			for(int i : output) {
				System.out.print(i);
			}
			System.out.println();
			return;
		}
		int temp[] = new int[output.length + 1];
		for(int i = 0; i < output.length; i++) {
			temp[i] = output[i];
		}
		temp[temp.length - 1] = arr[sI];
		printSubsets(arr, sI + 1, temp);
		printSubsets(arr, sI + 1, output);
	}
	
	public static void printSubsets(int[] arr) {
		int[] output = new int[0];
		printSubsets(arr, 0, output);
	}
	
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans[][] = arraySubset(arr);
		System.out.println("By returning!");
		for(int a[] : ans) {
			for(int x : a) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		System.out.println("By printing!");
		printSubsets(arr);
		sc.close();
	}

}
