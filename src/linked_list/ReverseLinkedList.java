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

	public static Node<Integer> reverseListRecursionBetter2(Node<Integer> head) {
		/*
		 * This is the best solution for this question, as we don't have to return,
		 * double values, as we know that the head's next is actually the current tail,
		 * so we can directly attach the head to the tail's next and then put null in
		 * head's next.
		 */
		if (head == null || head.next == null)
			return head;
		Node<Integer> reversedTail = head.next;
		Node<Integer> smallHead = reverseListRecursionBetter2(head.next);
		reversedTail.next = head;
		head.next = null;
		return smallHead;
	}

	public static DoubleNode reverseListRecursionBetter(Node<Integer> head) {
		if (head == null || head.next == null) {
			DoubleNode output = new DoubleNode();
			output.head = head;
			output.tail = head;
			return output;
		}
		DoubleNode smallAns = reverseListRecursionBetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		DoubleNode ans = new DoubleNode();
		ans.head = smallAns.head;
		ans.tail = head;
		return ans;
	}

	public static Node<Integer> reverseListRecursion(Node<Integer> head) {
		/*
		 * In this recursive approach the time complexity is O(n^2) as first we call
		 * recursion for each element and then iterate to the end of the list for each
		 * recursive call to add the head to the end of the list. So the recurrence
		 * relation relation is - T(n) = T(n - 1) + (n - 1). This can be improved if we
		 * simply return the tail with the head as well.
		 */
		if (head == null || head.next == null) {
			return head;
		}
		Node<Integer> finalHead = reverseListRecursion(head.next);
		Node<Integer> temp = finalHead;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;
		head.next = null;
		return finalHead;
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
//			Node<Integer> newHead = reverseList(head);
//			LinkedListUse.print(newHead);
//			LinkedListUse.print(reverseListRecursionBetter(head).head);
			LinkedListUse.print(reverseListRecursionBetter2(head));
		}
	}

}
