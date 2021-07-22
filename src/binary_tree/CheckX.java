package binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckX {
	
	public static BinaryTreeNode<Integer> takeInput(Scanner sc) {
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		if(rootData == -1) {
			sc.close();
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		
		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.remove();
			
			System.out.println("Enter left child data of " + frontNode.data);
			int leftData = sc.nextInt();
			if(leftData != -1) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftData);
				frontNode.left = left;
				pendingNodes.add(left);
			}
			
			System.out.println("Enter right child data of " + frontNode.data);
			int rightData = sc.nextInt();
			if(rightData != -1) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightData);
				frontNode.right = right;
				pendingNodes.add(right);
			}
		}
		sc.close();
		return root;
	}
	
	private static boolean checkX(BinaryTreeNode<Integer> root, int x, boolean ans) {
		if(root == null) {
			return ans;
		}
		if(root.data == x) {
			ans = true;
		}
		ans = checkX(root.left, x, ans);
		ans = checkX(root.right, x, ans);
		return ans;
	}

	public static boolean checkX(BinaryTreeNode<Integer> root, int x) {
		if(root == null) {
			return false;
		}
		return checkX(root, x, false);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x");
		int x = sc.nextInt();
		BinaryTreeNode<Integer> root = takeInput(sc);
		System.out.println(checkX(root, x));
	}

}
