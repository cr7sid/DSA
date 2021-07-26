package linked_list;

public class LinkedListUse {
	
	public static void print(Node<Integer> head) {
		
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		/*Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(12);
		System.out.println(node1.data);
		System.out.println(node1.next);
		node1.next = node2;
		System.out.println(node2.data);
		System.out.println(node2);
		System.out.println(node1.next);*/
		Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(30);
		node1.next = node2;
		node2.next = node3;
		Node<Integer> head = node1;
		print(head);
		print(head);
		
	}

}
