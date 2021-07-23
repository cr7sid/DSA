package binary_tree;

import java.util.Scanner;

public class BTUsingPreAndIn {

	private static BinaryTreeNode<Integer> constructionUsingPreAndinorder(int[] inorder, int[] preorder, int inSI,
			int inEI, int preSI, int preEI) {
		if (inSI > inEI || preSI > preEI) {
			return null;
		}
		int rootData = preorder[preSI];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		int i;
		for (i = inSI; i <= inEI; i++) {
			if (inorder[i] == rootData) {
				break;
			}
		}
		int leftInSI = inSI;
		int leftInEI = i - 1;
		int leftPreSI = preSI + 1;
		int leftPreEI = leftInEI - leftInSI + leftPreSI;
		int rightInSI = i + 1;
		int rightInEI = inEI;
		int rightPreSI = leftPreEI + 1;
		int rightPreEI = preEI;
		root.left = constructionUsingPreAndinorder(inorder, preorder, leftInSI, leftInEI, leftPreSI, leftPreEI);
		root.right = constructionUsingPreAndinorder(inorder, preorder, rightInSI, rightInEI, rightPreSI, rightPreEI);
		return root;
	}

	public static BinaryTreeNode<Integer> constructionUsingPreAndinorder(int[] inorder, int[] preorder) {
		return constructionUsingPreAndinorder(inorder, preorder, 0, inorder.length - 1, 0, inorder.length - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] preorder = new int[n];
		int[] inorder = new int[n];
		System.out.println("Enter preorder");
		for (int i = 0; i < n; i++) {
			preorder[i] = sc.nextInt();
		}
		System.out.println("Enter inorder");
		for (int i = 0; i < n; i++) {
			inorder[i] = sc.nextInt();
		}
		BinaryTreeNode<Integer> root = constructionUsingPreAndinorder(inorder, preorder);
		BinaryTreeUse.printLevelWise(root);
		sc.close();
	}
}
