package binary_tree;

import java.util.Scanner;

public class BTUsingPreAndIn {
	
	private static BinaryTreeNode<Integer> constructionUsingPreAndInOrder(int[] inOrder, int[] preOrder, int inSI, int inEI, int preSI, int preEI) {
		return null;
	}
	
	public static BinaryTreeNode<Integer> constructionUsingPreAndInOrder(int[] inOrder, int[] preOrder) {
		return constructionUsingPreAndInOrder(inOrder, preOrder, 0, inOrder.length - 1, 0, inOrder.length - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] preOrder = new int[n];
		int[] inOrder = new int[n];
		for(int i = 0; i < n; i++) {
			preOrder[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			inOrder[i] = sc.nextInt();
		}
		BinaryTreeNode<Integer> root = constructionUsingPreAndInOrder(inOrder, preOrder);
		sc.close();
	}
}
