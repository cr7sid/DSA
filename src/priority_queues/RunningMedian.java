package priority_queues;

import java.util.Scanner;

public class RunningMedian {

	public static int[] runningMedian(int[] arr) {
		int[] ans = new int[arr.length];
		MaxPriorityQueue lower = new MaxPriorityQueue();
		PriorityQueue higher = new PriorityQueue();
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				lower.insert(arr[i]);
				try {
					higher.insert(lower.removeMax());
					ans[i] = higher.getMin();
				} catch (PriorityQueueException e) {
					e.printStackTrace();
				}

			} else {
				higher.insert(arr[i]);
				try {
					lower.insert(higher.removeMin());
					ans[i] = (lower.getMax() + higher.getMin()) / 2;
				} catch (PriorityQueueException e) {
					e.printStackTrace();
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] ans = runningMedian(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		sc.close();
	}

}
