package linked_list;

public class EvenOddLL {

	public static Node<Integer> oddEvenLL(Node<Integer> head) {
		if (head == null)
			return head;
		Node<Integer> oddTail = head, evenTail = head.next, evenHead = head.next;
		while (evenTail != null && evenTail.next != null) {
			oddTail.next = evenTail.next;
			oddTail = oddTail.next;
			evenTail.next = oddTail.next;
			evenTail = evenTail.next;
		}
		oddTail.next = evenHead;
		return head;
	}

	public static void main(String[] args) {
		Node<Integer> head = LinkedListUse.takeInput();
		head = oddEvenLL(head);
		LinkedListUse.print(head);
	}

}
