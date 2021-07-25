package binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import binary_tree.BinaryTreeNode;

public class ElementsInRange {
	
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


	public static void elementsInRange(BinaryTreeNode<Integer> root, int k1, int k2) {
		if(root == null)
			return;
		if(root.data > k1) {
			elementsInRange(root.left, k1, k2);
		}
		if(root.data >= k1 && root.data <= k2)
			System.out.print(root.data + " ");
		if(root.data < k2) {
			elementsInRange(root.right, k1, k2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k1 = sc.nextInt();
		int k2 = sc.nextInt();
		BinaryTreeNode<Integer> root = takeInput(sc);
		elementsInRange(root, k1, k2);
	}

}
