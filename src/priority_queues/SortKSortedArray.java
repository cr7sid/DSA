package priority_queues;

public class SortKSortedArray {

	public static void sortKSorted(int[] arr, int k) {
		PriorityQueue pq = new PriorityQueue();
		int i = 0;
		for (; i < k; i++) {
			pq.insert(arr[i]);
		}
		for (; i < arr.length; i++) {
			try {
				arr[i - k] = pq.removeMin();
			} catch (PriorityQueueException e) {
				e.printStackTrace();
			}
			pq.insert(arr[i]);
		}
		for (int j = arr.length - k; j < arr.length; j++) {
			try {
				arr[j] = pq.removeMin();
			} catch (PriorityQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// Length of array must be greater than k.
		int[] arr = { 2, 4, 1, 9, 6, 8 };
		int k = 3;
		sortKSorted(arr, k);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
