package linked_list;

import java.util.Scanner;

public class NodeAtX {

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

	public static Node<Integer> nodeAtX(Node<Integer> head, int x) {
		if (head == null) {
			return head;
		}
		int i = 0;
		while (i < x) {
			head = head.next;
			i++;
		}
		return head;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Node<Integer> head = takeInput(sc);
			int x = sc.nextInt();
			Node<Integer> node = nodeAtX(head, x);
			if (node != null)
				System.out.println(node.data);
		}
	}

}
