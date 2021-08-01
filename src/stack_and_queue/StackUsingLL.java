package stack_and_queue;

public class StackUsingLL<T> {
	private Node<T> head;
	private int size;

	public StackUsingLL() {
		head = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void push(T ele) {
		Node<T> temp = new Node<>(ele);
		temp.next = head;
		head = temp;
		size++;
	}

	public T top() throws StackEmptyException {
		if (size() == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return head.data;
	}

	public T pop() throws StackEmptyException {
		if (size() == 0) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}

}
