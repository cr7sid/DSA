package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicates {

	public static ArrayList<Integer> removeDuplicates(int[] a) {
		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer, Boolean> seen = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (seen.containsKey(a[i]))
				continue;
			output.add(a[i]);
			seen.put(a[i], true);
		}
		return output;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		ArrayList<Integer> output = removeDuplicates(a);
		for (int x : output) {
			System.out.print(x + " ");
		}
		sc.close();
	}

}
