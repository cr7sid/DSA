package priority_queues;

import java.util.Scanner;

public class KLargestElements {

	public static void kLargestElements(int[] arr, int k) {
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
		while (!pq.isEmpty()) {
			try {
				System.out.print(pq.removeMin() + " ");
			} catch (PriorityQueueException e) {
				e.printStackTrace();
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
		kLargestElements(arr, k);
		sc.close();
	}

}
