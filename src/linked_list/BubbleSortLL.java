package linked_list;

public class BubbleSortLL {

	public static int length(Node<Integer> head) {
		int size = 0;
		if (head == null) {
			return size;
		}
		while (head != null) {
			head = head.next;
			size++;
		}
		return size;
	}

	public static Node<Integer> bubbleSort(Node<Integer> head) {
		if (head == null || head.next == null)
			return head;
		int i, j, k;
		int len = length(head);
		Node<Integer> p = head;
		Node<Integer> q = p.next;

		for (i = 0; i < len - 1; i++, p = p.next) {
			for (j = i + 1, q = p.next; j < len; j++, q = q.next) {
				if (p.data > q.data) {
					k = p.data;
					p.data = q.data;
					q.data = k;
				}
			}
		}

		return head;
	}

	public static void main(String[] args) {
		Node<Integer> head = LinkedListUse.takeInput();
		head = bubbleSort(head);
		LinkedListUse.print(head);
	}

}
