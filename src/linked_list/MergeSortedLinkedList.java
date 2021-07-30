package linked_list;

import java.util.Scanner;

public class MergeSortedLinkedList {

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

	public static Node<Integer> mergeLL(Node<Integer> head1, Node<Integer> head2) {
		if(head1 == null && head2 == null) {
            return null;
        } else if(head1 == null) {
            return head2;
        } else if(head2 == null) {
            return head1;
        }
		Node<Integer> head3 = null, tail3 = null;
		while(head1 != null && head2 != null) {
			if(head3 == null) {
				if(head1.data <= head2.data) {
					head3 = head1;
					tail3 = head1;
					head1 = head1.next;
				} else {
					head3 = head2;
					tail3 = head2;
					head2 = head2.next;
				}
			} else {
				if(head1.data <= head2.data) {
					tail3.next = head1;
					head1 = head1.next;
					tail3 = tail3.next;
				} else {
					tail3.next = head2;
					head2 = head2.next;
					tail3 = tail3.next;
				}
			}
		}
		while(head1 != null) {
			tail3.next = head1;
			head1 = head1.next;
			tail3 = tail3.next;
		}
		while(head2 != null) {
			tail3.next = head2;
			head2 = head2.next;
			tail3 = tail3.next;
		}
		return head3;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node<Integer> head1 = takeInput(sc);
		Node<Integer> head2 = takeInput(sc);
		LinkedListUse.print(mergeLL(head1, head2));
	}

}
