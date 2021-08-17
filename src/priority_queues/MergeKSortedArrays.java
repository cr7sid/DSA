package priority_queues;

import java.util.Scanner;

public class MergeKSortedArrays {

	public static int[] mergeKSorted(int[][] arrays) {
		int n = 0;
		PriorityQueue pq = new PriorityQueue();
		for (int i = 0; i < arrays.length; i++) {
			n += arrays[i].length;
			for (int j = 0; j < arrays[i].length; j++) {
				pq.insert(arrays[i][j]);
			}
		}
		int[] ans = new int[n];
		int k = 0;
		while (!pq.isEmpty()) {
			try {
				ans[k] = pq.removeMin();
			} catch (PriorityQueueException e) {
				e.printStackTrace();
			}
			k++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int k;
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		int[][] arrays = new int[k][];
		for (int i = 0; i < k; i++) {
			int n = sc.nextInt();
			arrays[i] = new int[n];
			for (int j = 0; j < n; j++) {
				arrays[i][j] = sc.nextInt();
			}
		}
		int[] ans = mergeKSorted(arrays);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		sc.close();
	}

}
