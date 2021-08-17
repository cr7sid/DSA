package priority_queues;

import java.util.Scanner;

public class KthLargest {

	public static void kthLargest(int[] arr, int k) {
		PriorityQueue pq = new PriorityQueue();
		int i = 0;
		for (; i < k; i++) {
			pq.insert(arr[i]);
		}
		for (; i < arr.length; i++) {
			try {
				if (pq.getMin() < arr[i]) {
					pq.removeMin();
					pq.insert(arr[i]);
				}
			} catch (PriorityQueueException e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println(pq.getMin());
		} catch (PriorityQueueException e) {
			e.printStackTrace();
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
		kthLargest(arr, k);
		sc.close();
	}
}
