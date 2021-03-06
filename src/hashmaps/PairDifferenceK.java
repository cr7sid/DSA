package hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class PairDifferenceK {

	public static void pairsWithDiffK(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			int p1 = i + k;
			boolean flag = false;
			if (i == p1) {
				flag = true;
			}
			if (map.containsKey(p1)) {
				int f2 = map.get(p1);
				for (int j = 0; j < f2; j++) {
					if (p1 < i) {
						System.out.println(p1 + " " + i);
					} else {
						System.out.println(i + " " + p1);
					}
				}
			}
			int p2 = i - k;
			if (map.containsKey(p2) && !flag) {
				int f2 = map.get(p2);
				for (int j = 0; j < f2; j++) {
					if (p2 < i) {
						System.out.println(p2 + " " + i);
					} else {
						System.out.println(i + " " + p2);
					}
				}
			}
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		pairsWithDiffK(arr, k);
		sc.close();
	}

}
