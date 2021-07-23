package binary_tree;

import java.util.Scanner;

public class BTUsingPostAndIn {

	private static BinaryTreeNode<Integer> constructionUsingPostAndinorder(int[] inorder, int[] postorder, int inSI,
			int inEI, int postSI, int postEI) {
		if (inSI > inEI || postSI > postEI) {
			return null;
		}
		int rootData = postorder[postEI];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		int i;
		for (i = inSI; i <= inEI; i++) {
			if (inorder[i] == rootData) {
				break;
			}
		}
		int leftInSI = inSI;
		int leftInEI = i - 1;
		int leftPostSI = postSI;
		int leftPostEI = leftInEI - leftInSI + leftPostSI;
		int rightInSI = i + 1;
		int rightInEI = inEI;
		int rightPostSI = leftPostEI + 1;
		int rightPostEI = postEI - 1;
		root.left = constructionUsingPostAndinorder(inorder, postorder, leftInSI, leftInEI, leftPostSI, leftPostEI);
		root.right = constructionUsingPostAndinorder(inorder, postorder, rightInSI, rightInEI, rightPostSI, rightPostEI);
		return root;
	}

	public static BinaryTreeNode<Integer> constructionUsingPostAndinorder(int[] inorder, int[] postorder) {
		return constructionUsingPostAndinorder(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] postorder = new int[n];
		int[] inorder = new int[n];
		System.out.println("Enter postorder");
		for (int i = 0; i < n; i++) {
			postorder[i] = sc.nextInt();
		}
		System.out.println("Enter inorder");
		for (int i = 0; i < n; i++) {
			inorder[i] = sc.nextInt();
		}
		BinaryTreeNode<Integer> root = constructionUsingPostAndinorder(inorder, postorder);
		BinaryTreeUse.printLevelWise(root);
		sc.close();
	}
}
