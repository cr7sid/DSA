package linked_list;

import java.util.Scanner;

public class AppendLastNToFirst {

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

	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
		if (head == null)
			return null;
		if (n == 0)
			return head;
		int len = LinkedListLength.length(head);
		if(n >= len)
			return null;
		Node<Integer> temp = head;
		Node<Integer> temp1 = head;
		int i = len - n;
		while (i > 1) {
			temp = temp.next;
			i--;
		}
		temp1 = temp.next;
		Node<Integer> t = temp.next;
		temp.next = null;
		while (t.next != null) {
			t = t.next;
		}
		t.next = head;
		head = temp1;
		return head;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Node<Integer> head = takeInput(sc);
			int n = sc.nextInt();
			Node<Integer> newHead = appendLastNToFirst(head, n);
			LinkedListUse.print(newHead);
		}
	}

}
