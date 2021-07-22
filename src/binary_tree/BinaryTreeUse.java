package binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse {
	
	public static void print(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		String toPrint = root.data + ":";
		if(root.left != null) {
			toPrint += "L" + root.left.data + ",";
		}
		if(root.right != null) {
			toPrint += "R" + root.right.data;
		}
		System.out.println(toPrint);
		print(root.left);
		print(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeInput(Scanner sc) {
		System.out.println("Enter next node");
		int rootData = sc.nextInt();
		if(rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		root.left = takeInput(sc);
		root.right = takeInput(sc);
		return root;
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		
		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.remove();
			String toPrint = frontNode.data + ":";
			if(frontNode.left != null) {
				toPrint += "L:" + frontNode.left.data + ",";
				pendingNodes.add(frontNode.left);
			}
			if(frontNode.right != null) {
				toPrint += "R:" + frontNode.right.data;
				pendingNodes.add(frontNode.right);
			}
			System.out.println(toPrint);
		}
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner sc = new Scanner(System.in);
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
	
	public static void main(String[] args) {
		/*BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
		root.left = node1;
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
		root.right = node2;
		System.out.print(root);

		System.out.println("With recursion");
		Scanner sc = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(sc);
		print(root);*/
		System.out.println("Without recursion");
		BinaryTreeNode<Integer> root1 = takeInputLevelWise();
		printLevelWise(root1);
	}
	
}
