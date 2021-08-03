package stack_and_queue;

import java.util.Scanner;

public class ReverseQueue {

	public static void reverseQueue(QueueUsingLL<Integer> queue) {
		if (queue.isEmpty()) {
			return;
		}
		int temp = 0;
		try {
			temp = queue.dequeue();
		} catch (QueueEmptyException e) {
			e.printStackTrace();
		}
		reverseQueue(queue);
		System.out.print(temp + " ");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QueueUsingLL<Integer> queue = new QueueUsingLL<>();
		int n = sc.nextInt();
		while (n-- > 0) {
			queue.enqueue(sc.nextInt());
		}
		reverseQueue(queue);
		sc.close();
	}
}
