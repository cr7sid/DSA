package hashmaps;

import java.util.*;

public class MaxFrequency {

	public static int maxFrequencyNumber(int[] arr) {

		HashMap<Integer, Integer> kid = new HashMap<>();

		for (int key : arr) {
			if (kid.containsKey(key))
				kid.put(key, kid.get(key) + 1);
			else
				kid.put(key, 1);
		}

		int maxx = Integer.MIN_VALUE;
		int number = arr[0];
		for (int key : arr) {
			if (kid.get(key) > maxx) {
				maxx = kid.get(key);
				number = key;
			}
		}
		return number;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = maxFrequencyNumber(arr);
		System.out.println(ans);
		sc.close();
	}

}
