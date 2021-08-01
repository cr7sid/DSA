package stack_and_queue;

public class StackUse {

	public static void main(String[] args) throws StackEmptyException {
		/*StackUsingArray stack = new StackUsingArray();
		for (int i = 0; i < 20; i++) {
			stack.push(i + 1);
		}
		while (!stack.isEmpty()) {
			try {
				System.out.println(stack.pop());
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
		}*/
		StackUsingLL<Integer> stack = new StackUsingLL<>();
		for (int i = 0; i < 20; i++) {
			stack.push(i + 1);
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
