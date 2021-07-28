package linked_list;

public class DeleteNode {

	public static Node<Integer> delete(Node<Integer> head, int pos) {
		if (pos == 0) {
			head = head.next;
			return head;
		}
		int i = 0;
		Node<Integer> temp = head;
		while (i < pos - 1) {
			temp = temp.next;
			i++;
		}
		if (temp.next != null) {
			temp.next = temp.next.next;
		} else {
			System.out.println("Element to be deleted not found");
		}
		return head;
	}

	public static void main(String[] args) {
		Node<Integer> head = LinkedListUse.takeInput();
		LinkedListUse.print(head);
		head = delete(head, 4);
		LinkedListUse.print(head);
	}

}
