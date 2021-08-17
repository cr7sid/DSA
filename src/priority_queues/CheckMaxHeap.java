package priority_queues;

import java.util.Scanner;

public class CheckMaxHeap {

	public static boolean checkMaxHeap(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			if ((2 * i + 1) < n) {
				if (arr[2 * i + 1] > arr[i]) {
					return false;
				}
			}
			if ((2 * i + 2) < n) {
				if (arr[2 * i + 2] > arr[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(checkMaxHeap(arr));
		sc.close();
	}

}
