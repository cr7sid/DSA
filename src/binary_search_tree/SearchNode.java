package binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binary_tree.BinaryTreeNode;
import binary_tree.BinaryTreeUse;

public class SearchNode {

	public static BinaryTreeNode<Integer> takeInput(Scanner sc) {
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		if (rootData == -1) {
			sc.close();
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.remove();

			System.out.println("Enter left child data of " + frontNode.data);
			int leftData = sc.nextInt();
			if (leftData != -1) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftData);
				frontNode.left = left;
				pendingNodes.add(left);
			}

			System.out.println("Enter right child data of " + frontNode.data);
			int rightData = sc.nextInt();
			if (rightData != -1) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightData);
				frontNode.right = right;
				pendingNodes.add(right);
			}
		}
		sc.close();
		return root;
	}

	public static BinaryTreeNode<Integer> searchBST(BinaryTreeNode<Integer> root, int val) {
		if (root == null)
			return null;
		if (root.data == val)
			return root;
		else if (val < root.data)
			return searchBST(root.left, val);
		else
			return searchBST(root.right, val);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		BinaryTreeNode<Integer> root = takeInput(sc);
		BinaryTreeNode<Integer> ansRoot = searchBST(root, x);
		BinaryTreeUse.printLevelWise(ansRoot);
	}

}
