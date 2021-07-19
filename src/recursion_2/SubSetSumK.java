package recursion_2;

import java.util.Scanner;

public class SubSetSumK {
	
	//TODO: Try and complete!
	
	private static int[][] subsetSumK(int[] arr, int k, int sI) {
		if(sI >= arr.length) {
			int a[][] = {{}};
			return a;
		}
		int[][] smallAns = subsetSumK(arr, sI + 1);
		int[][] ans = new int[smallAns.length * 2][];
		
		for(int i = 0; i < smallAns.length; i++) {
			ans[i] = new int[smallAns[i].length];
			int sum = 0;
			for(int j = 0; j < smallAns[i].length; j++) {
				sum += smallAns[i][j];;
			}
			if(sum == k) {
				for(int j = 0; j < smallAns[i].length; j++) {
					ans[i][j] = smallAns[i][j];
				}
			}
		}
		for(int i = smallAns.length; i < ans.length; i++) {
			ans[i] = new int[smallAns[i - smallAns.length].length + 1];
			int sum = 0;
			sum += arr[sI];
			for(int j = 1; j < ans[i].length; j++) {
				sum += smallAns[i - smallAns.length][j - 1];
			}
			if(sum == k) {
				ans[i][0] = arr[sI];
				for(int j = 1; j < ans[i].length; j++) {
					ans[i][j] = smallAns[i - smallAns.length][j - 1];
				}
			}
		}
		return ans;
	}
	
	public static int[][] subsetSumK(int[] arr, int k) {
		return subsetSumK(arr, k, 0);
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k;
		k = sc.nextInt();
		int ans[][] = subsetSumK(arr, k);
		System.out.println("By returning!");
		for(int a[] : ans) {
			for(int x : a) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
