package linked_list;

import java.util.Scanner;

public class KReverse {

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

	public static Node<Integer> reverseList(Node<Integer> head) {
		if (head == null)
			return null;
		Node<Integer> current = head;
		Node<Integer> prev = null;
		while (current != null) {
			Node<Integer> nextTemp = current.next;
			current.next = prev;
			prev = current;
			current = nextTemp;
		}
		return prev;
	}

	public static Node<Integer> kReverse(Node<Integer> head, int k) {
		Node<Integer> prev = null;
		Node<Integer> curr = head;
		Node<Integer> next = null;
		int count = 0;
		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if (next != null)
			head.next = kReverse(next, k);
		return prev;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node<Integer> head = takeInput(sc);
		int k = sc.nextInt();
		head = kReverse(head, k);
		LinkedListUse.print(head);
	}
}
