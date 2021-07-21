package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NodesAtDepthK {
	
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
	
	public static void nodesAtDepthK(TreeNode<Integer> root, int k) {
		if(k < 0) {
			return;
		}
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		for(int i = 0; i < root.children.size(); i++) {
			nodesAtDepthK(root.children.get(i), k - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeNode<Integer> root = takeInput(sc);
		System.out.println("Enter k");
		int k = sc.nextInt();
		nodesAtDepthK(root, k);
		sc.close();
	}

}
