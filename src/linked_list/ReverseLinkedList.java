package linked_list;

import java.util.Scanner;

public class ReverseLinkedList {

	public static Node<Integer> takeInput(Scanner sc) {
		Node<Integer> head = null;
		Node<Integer> tail = null;
		int data = sc.nextInt();
		while (data != -1) {
			Node<Integer> newNode = new Node<>(data);
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Node<Integer> head = takeInput(sc);
			Node<Integer> newHead = reverseList(head);
			LinkedListUse.print(newHead);
		}
	}

}
