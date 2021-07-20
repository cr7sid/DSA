package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {
	
	private static TreeNode<Integer> takeInput(Scanner sc) {
		//Using recursion.
		int n;
		System.out.println("Enter next node data");
		n = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		System.out.println("Enter number of children for " + n);
		int childCount = sc.nextInt();
		for(int i = 0; i < childCount; i++) {
			TreeNode<Integer> child = takeInput(sc);
			root.children.add(child);
		}
		return root;
	}
	
	public static TreeNode<Integer> takeInput() {
		Scanner sc = new Scanner(System.in);
		return takeInput(sc);
	}
	
	public static void print(TreeNode<Integer> root) {
		//Using recursion.
		String s = root.data + ":";
		for(int i = 0; i < root.children.size(); i++) {
			s += root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}
	
	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = sc.nextInt();
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode = pendingNodes.remove();
			System.out.println("Enter number of children of " + frontNode.data);
			int childCount = sc.nextInt();
			for(int i = 0; i < childCount; i++) {
				System.out.println("Enter data of " + (i + 1) + "th child of " + frontNode.data);
				int childData = sc.nextInt();
				TreeNode<Integer> node = new TreeNode<Integer>(childData);
				frontNode.children.add(node);
				pendingNodes.add(node);
			}
		}
		sc.close();
		return root;
	}
	
	public static void printLevelWise(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode = pendingNodes.remove();
			String s = frontNode.data + ":";
			for(int i = 0; i < frontNode.children.size(); i++) {
				s += frontNode.children.get(i).data + ",";
				pendingNodes.add(frontNode.children.get(i));
			}
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		/* Tree Demo.
		TreeNode<Integer> root = new TreeNode<Integer>(4);
		TreeNode<Integer> node1 = new TreeNode<Integer>(2);
		TreeNode<Integer> node2 = new TreeNode<Integer>(3);
		TreeNode<Integer> node3 = new TreeNode<Integer>(5);
		TreeNode<Integer> node4 = new TreeNode<Integer>(6);
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		
		node2.children.add(node4);
		
		System.out.print(root);*/
		
		//System.out.println("Using recursion");
		//TreeNode<Integer> root = takeInput();
		//print(root);
		System.out.println("Without recursion");
		TreeNode<Integer> root1 = takeInputLevelWise();
		printLevelWise(root1);
	}
}
