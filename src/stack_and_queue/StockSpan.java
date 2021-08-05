package stack_and_queue;

import java.util.Scanner;

public class StockSpan {

	public static int[] stockSpan(int[] arr, int n) {
		int[] ans = new int[n];
		StackUsingLL<Integer> stack = new StackUsingLL<>();
		stack.push(0);
		ans[0] = 1;
		for (int i = 1; i < n; i++) {
			System.out.println(arr[i]);
			try {
				while (!stack.isEmpty() && arr[stack.top()] <= arr[i])
					stack.pop();
				ans[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.top());
				stack.push(i);
			} catch (StackEmptyException e) {
				e.printStackTrace();
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] ans = stockSpan(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
		sc.close();
	}

}
