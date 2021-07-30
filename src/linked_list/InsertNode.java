package linked_list;

public class InsertNode {

	public static Node<Integer> insertRecursively(Node<Integer> head, int data, int pos) {
		if (pos == 0) {
			Node<Integer> newNode = new Node<>(data);
			newNode.next = head;
			head = newNode;
			return newNode;
		}
		if (head == null)
			return head;

		head.next = insertRecursively(head.next, data, pos - 1);
		return head;
	}

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
//		head = insert(head, 80, 3);
		head = insertRecursively(head, 80, 4);
		LinkedListUse.print(head);
	}

}
