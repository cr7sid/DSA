package hashmaps;

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutive {

	public static int[] longestConsecutiveSubsequence(int[] arr, int n) {
		HashSet<Integer> set = new HashSet<>();
		int max = Integer.MIN_VALUE;
		int val = arr[0];
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}
		for (int i = 0; i < n; i++) {
			if (!set.contains(arr[i] - 1)) {
				int j = arr[i];
				while (set.contains(j))
					j++;
				if (max < j - arr[i]) {
					max = j - arr[i];
					val = j;
				}
			}
		}
		System.out.println(val + " " + max);
		int[] output = new int[max];
		for (int i = 0; i < max; i++) {
			output[i] = val - max + i;
		}
		return output;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		arr = longestConsecutiveSubsequence(arr, n);
		for (int x : arr) {
			System.out.println(x);
		}
		sc.close();
	}

}
