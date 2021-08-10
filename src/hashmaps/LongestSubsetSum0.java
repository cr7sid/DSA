package hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubsetSum0 {

	// TODO: Learn and solve.

	public static int longestSubsetSum0(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		if (arr.length == 1 && arr[0] == 0) {
			return 1;
		}
		int i = 0;
		int max = 0;
		int sum = 0;
		for (int elem : arr) {
			sum += elem;
			if (map.containsKey(sum)) {
				int x = Math.abs(map.get(sum) - i);
				if (x > max) {
					max = x;
				}
			} else {
				map.put(sum, i);
			}
			i++;
		}
		return max;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = longestSubsetSum0(arr);
		System.out.println(ans);
		sc.close();
	}

}
