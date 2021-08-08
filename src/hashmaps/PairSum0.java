package hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class PairSum0 {

	public static void pairSum0(int[] input) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int element : input) {
			if (map.containsKey(element)) {
				map.put(element, map.get(element) + 1);
			} else {
				map.put(element, 1);
			}
		}

		for (int element : input) {
			int pairElement = -1 * element;
			if (map.containsKey(pairElement)) {
				int freq = map.get(pairElement);
				if (map.containsKey(element)) {
					freq *= map.get(element);
				}
				map.put(element, 0);
				map.put(pairElement, 0);
				while (freq-- > 0) {
					System.out.println(
							element < (-1 * element) ? element + " " + (-1 * element) : (-1 * element) + " " + element);
				}
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
		pairSum0(arr);
		sc.close();
	}
}
