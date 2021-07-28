package linked_list;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

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

	public static Node<Integer> reverse(Node<Integer> head) {
		Node<Integer> prev = null;
		while (head != null) {
			Node<Integer> nextTemp = head.next;
			head.next = prev;
			prev = head;
			head = nextTemp;
		}
		return prev;
	}

	public static boolean palindrome1(Node<Integer> head) {
		if (head == null)
			return true;
		Node<Integer> slow = head;
		Node<Integer> fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		slow = reverse(slow);
		fast = head;

		while (slow != null) {
			if (slow.data != fast.data) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}

		return true;
	}

	public static boolean palindrome(Node<Integer> head) {
		boolean bool = true;
		if (head == null)
			return true;
		int len = LinkedListLength.length(head);
		Stack<Integer> s = new Stack<>();
		Node<Integer> temp = head;
		int i = len / 2;
		while (i > 0) {
			s.add(temp.data);
			temp = temp.next;
			i--;
		}
		if (len % 2 != 0) {
			temp = temp.next;
		}
		while (temp != null) {
			if (s.pop() != temp.data) {
				bool = false;
				break;
			}
			temp = temp.next;
		}
		return bool;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			Node<Integer> head = takeInput(sc);
			boolean bool = palindrome1(head);
			System.out.println(bool);
		}
	}

}
