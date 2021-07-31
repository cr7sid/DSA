package linked_list;

import java.util.Scanner;

public class DeleteEveryNNodes {

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

	public static Node<Integer> deleteEveryNNodes(Node<Integer> head, int m, int n) {
		if (head == null)
			return head;
		Node<Integer> temp = head;
		int i = 0;
		while (temp != null) {
			i++;
			if (i == m) {
				i = n;
				while (temp != null && temp.next != null && i > 0) {
					temp.next = temp.next.next;
					i--;
				}
				i = 0;
			}
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node<Integer> head = takeInput(sc);
		int m = sc.nextInt();
		int n = sc.nextInt();
		head = deleteEveryNNodes(head, m, n);
		LinkedListUse.print(head);
	}
}
