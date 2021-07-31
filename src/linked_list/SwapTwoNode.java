package linked_list;

import java.util.Scanner;

public class SwapTwoNode {

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

	public static Node<Integer> swapTwoNodes(Node<Integer> head, int i, int j) {
		if (head == null || i == j)
			return head;
		int count = 0;
		Node<Integer> temp = head;
		Node<Integer> nodeAtI = head;
		while (temp != null) {
			if (count == i) {
				nodeAtI = temp;
			}
			if (count == j) {
				int t = nodeAtI.data;
				nodeAtI.data = temp.data;
				temp.data = t;
				break;
			}
			count++;
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node<Integer> head = takeInput(sc);
		int i = sc.nextInt();
		int j = sc.nextInt();
		if (i > j) {
			int temp = i;
			i = j;
			j = temp;
		}
		head = swapTwoNodes(head, i, j);
		LinkedListUse.print(head);
	}

}
