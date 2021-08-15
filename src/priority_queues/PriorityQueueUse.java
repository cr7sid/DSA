package priority_queues;

public class PriorityQueueUse {

	public static void insertIntoVirtualMinHeap(int[] arr, int index) {
		int parentIndex = (index - 1) / 2;
		while (index > 0) {
			if (arr[index] < arr[parentIndex]) {
				int temp = arr[index];
				arr[index] = arr[parentIndex];
				arr[parentIndex] = temp;
				index = parentIndex;
				parentIndex = (index - 1) / 2;
			} else {
				return;
			}
		}
	}

	public static void insertIntoVirtualMaxHeap(int[] arr, int index) {
		int parentIndex = (index - 1) / 2;
		while (index > 0) {
			if (arr[index] > arr[parentIndex]) {
				int temp = arr[index];
				arr[index] = arr[parentIndex];
				arr[parentIndex] = temp;
				index = parentIndex;
				parentIndex = (index - 1) / 2;
			} else {
				return;
			}
		}
	}

	public static int removeMinFromVirtualHeap(int[] arr, int size) {
		int temp = arr[0];
		arr[0] = arr[size - 1];
		size--;
		int index = 0;
		int minIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;

		while (leftChildIndex < size) {
			if (arr[leftChildIndex] < arr[minIndex]) {
				minIndex = leftChildIndex;
			}
			if (rightChildIndex < size && arr[rightChildIndex] < arr[minIndex]) {
				minIndex = rightChildIndex;
			}
			if (minIndex == index) {
				break;
			} else {
				int temp1 = arr[index];
				arr[index] = arr[minIndex];
				arr[minIndex] = temp1;
				index = minIndex;
				leftChildIndex = 2 * index + 1;
				rightChildIndex = 2 * index + 2;
			}
		}
		return temp;
	}

	public static int removeMaxFromVirtualHeap(int[] arr, int size) {
		int temp = arr[0];
		arr[0] = arr[size - 1];
		size--;
		int index = 0;
		int maxIndex = index;
		int leftChildIndex = 1;
		int rightChildIndex = 2;

		while (leftChildIndex < size) {
			if (arr[leftChildIndex] > arr[maxIndex]) {
				maxIndex = leftChildIndex;
			}
			if (rightChildIndex < size && arr[rightChildIndex] > arr[maxIndex]) {
				maxIndex = rightChildIndex;
			}
			if (maxIndex == index) {
				break;
			} else {
				int temp1 = arr[index];
				arr[index] = arr[maxIndex];
				arr[maxIndex] = temp1;
				index = maxIndex;
				leftChildIndex = 2 * index + 1;
				rightChildIndex = 2 * index + 2;
			}
		}
		return temp;
	}

	public static void main(String[] args) throws PriorityQueueException {
		int[] arr = { 10, 8, 12, 18, 5, 4, 7 };
		for (int i = 0; i < arr.length; i++) {
			insertIntoVirtualMaxHeap(arr, i);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "i");
		}
		for (int i = 0; i < arr.length; i++) {
			arr[arr.length - i - 1] = removeMaxFromVirtualHeap(arr, arr.length - i);
		}
		for (int i = 0; i < arr.length; i++) {
			// Here we have use min heap method to remove the elements, so we will get the
			// output
			// in reversed order. So we can either reverse this or use max heap method to
			// remove.
			System.out.println(arr[i]);
		}
//		PriorityQueue pq = new PriorityQueue();
//		int[] arr = { 10, 8, 12, 18, 5, 4, 7 };
//
//		for (int i = 0; i < arr.length; i++) {
//			pq.insert(arr[i]);
//		}
//		while (!pq.isEmpty()) {
//			System.out.println(pq.removeMin());
//		}
	}
}
