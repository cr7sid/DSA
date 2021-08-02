package stack_and_queue;

public class QueueUsingLL<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size;

	public QueueUsingLL() {
		front = null;
		rear = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void enqueue(T ele) {
		Node<T> newNode = new Node<>(ele);
		if (rear == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}

	public T top() throws QueueEmptyException {
		if (size() == 0) {
			throw new QueueEmptyException();
		}
		return front.data;
	}

	public T dequeue() throws QueueEmptyException {
		if (size() == 0) {
			throw new QueueEmptyException();
		}
		T temp = front.data;
		front = front.next;
		if (size == 1) {
			rear = null;
		}
		size--;
		return temp;
	}

}
