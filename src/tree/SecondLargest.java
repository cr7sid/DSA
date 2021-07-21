package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SecondLargest {
	
	public static TreeNode<Integer> takeInput(Scanner sc) {
		System.out.println("Enter root node");
		int rootData = sc.nextInt();
		TreeNode<Integer> root = new TreeNode<>(rootData);
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> frontNode = pendingNodes.remove();
			System.out.println("Enter number of children of " + frontNode.data);
			int numChild = sc.nextInt();
			for(int i = 0; i < numChild; i++) {
				System.out.println("Enter "+ (i + 1) + "th children of " + frontNode.data);
				int childData = sc.nextInt();
				TreeNode<Integer> childNode = new TreeNode<>(childData);
				pendingNodes.add(childNode);
				frontNode.children.add(childNode);
			}
		}
		return root;
	}
	
	private static TreeNode<Integer> secondLargest(TreeNode<Integer> root, TreeNode<Integer> largest, TreeNode<Integer> secondLargest) {
		
		if(root.data < largest.data) {
			if(secondLargest == null)
				secondLargest = root;
			else if(root.data > secondLargest.data) 
				secondLargest = root;
		}
		for(int i = 0; i < root.children.size(); i++) {
			secondLargest = secondLargest(root.children.get(i), largest, secondLargest);
		}
		return secondLargest;
	}
	
	public static TreeNode<Integer> secondLargest(TreeNode<Integer> root) {
		if(root == null || root.children.size() == 0) {
			return null;
		}
		TreeNode<Integer> largest = LargestNode.largestNode(root);
		return secondLargest(root, largest, null);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeNode<Integer> root = takeInput(sc);
		TreeNode<Integer> ans = secondLargest(root);
		System.out.println((ans != null) ? ans.data : "null");
		sc.close();
	}

}
