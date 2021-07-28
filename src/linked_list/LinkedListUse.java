package linked_list;

import java.util.Scanner;

public class LinkedListUse {

	public static Node<Integer> takeInput() {
		Scanner sc = new Scanner(System.in);
		Node<Integer> head = null;
		Node<Integer> tail = null;
		int data = sc.nextInt();
		/*
		 * The time complexity in this approach is O(n^2) because we are iteratively
		 * finding the last node for each node. So to decrease the time complexity, we
		 * can use a tail node which will point to the last node, so we won't have to
		 * find the last node everytime. while(data != -1) { Node<Integer> newNode = new
		 * Node<Integer>(data); if(head == null) { head = newNode; } else {
		 * Node<Integer> temp = head; while(temp.next != null) { temp = temp.next; }
		 * temp.next = newNode; } data = sc.nextInt(); }
		 */

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
		sc.close();
		return head;
	}

	public static void print(Node<Integer> head) {

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		/*
		 * Node<Integer> node1 = new Node<>(10); Node<Integer> node2 = new Node<>(12);
		 * System.out.println(node1.data); System.out.println(node1.next); node1.next =
		 * node2; System.out.println(node2.data); System.out.println(node2);
		 * System.out.println(node1.next);
		 */
		Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(30);
		node1.next = node2;
		node2.next = node3;
		Node<Integer> head = node1;
		print(head);
		print(head);

		Node<Integer> head1 = takeInput();
		print(head1);

	}
}
