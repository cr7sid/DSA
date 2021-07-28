package linked_list;

public class InsertNode {

	public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
		Node<Integer> newNode = new Node<>(data);
		if (pos == 0) {
			newNode.next = head;
			head = newNode;
			return head;
		}
		int i = 0;
		Node<Integer> temp = head;
		while (i < pos - 1) {
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}

	public static void main(String[] args) {
		Node<Integer> head = LinkedListUse.takeInput();
		LinkedListUse.print(head);
		head = insert(head, 80, 3);
		LinkedListUse.print(head);
	}

}
