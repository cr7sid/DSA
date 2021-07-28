package linked_list;

import java.util.Scanner;

public class LinkedListLength {

	public static Node<Integer> takeInput(Scanner sc) {
		Node<Integer> head = null;
		Node<Integer> tail = null;
		int data = sc.nextInt();
		while (data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = sc.nextInt();
		}
		return head;
	}

	public static int length(Node<Integer> head) {
		int size = 0;
		if (head == null) {
			return size;
		}
		while (head != null) {
			head = head.next;
			size++;
		}
		return size;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Node<Integer> head = takeInput(sc);
			int size = length(head);
			System.out.println(size);
		}
	}
}
