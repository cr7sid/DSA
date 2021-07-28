package linked_list;

import java.util.Scanner;

public class FindNode {

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

	private static int findNodeRecursive(Node<Integer> head, int n, int ans) {
		if (head == null)
			return -1;
		if (head.data == n)
			return ans;
		ans = findNodeRecursive(head.next, n, ans + 1);
		return ans;
	}

	public static int findNodeRecursive(Node<Integer> head, int n) {
		return findNodeRecursive(head, n, 0);
	}

	public static int findNode(Node<Integer> head, int n) {
		int ans = -1;
		if (head == null)
			return ans;
		int i = 0;
		while (head != null) {
			if (head.data == n) {
				ans = i;
				break;
			}
			head = head.next;
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Node<Integer> head = takeInput(sc);
			int n = sc.nextInt();
			int pos = findNodeRecursive(head, n);
			System.out.println(pos);
		}
	}

}
