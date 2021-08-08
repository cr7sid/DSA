package hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class ArrayIntersection {

	public static void intersection(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr1.length; i++) {
			if (!map.containsKey(arr1[i])) {
				map.put(arr1[i], 1);
			} else {
				map.put(arr1[i], map.get(arr1[i]) + 1);
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			if (map.containsKey(arr2[i])) {
				int value = map.get(arr2[i]);
				if (value > 0) {
					System.out.println(arr2[i]);
					map.put(arr2[i], value - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		m = sc.nextInt();
		int[] arr1 = new int[m];
		for (int i = 0; i < m; i++) {
			arr1[i] = sc.nextInt();
		}
		intersection(arr, arr1);
		sc.close();
	}

}
