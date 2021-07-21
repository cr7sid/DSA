package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NextLarger {
	
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
	
	private static TreeNode<Integer> nextLarger(TreeNode<Integer> root, int n, TreeNode<Integer> ans) {
		if(ans == null) {
			if(root.data > n)
				ans = root;
		} else {
			if(root.data > n && root.data < ans.data)
				ans = root;
		}
		for(int i = 0; i < root.children.size(); i++) {
			ans = nextLarger(root.children.get(i), n, ans);
		}
		return ans;
	}
	
	public static TreeNode<Integer> nextLarger(TreeNode<Integer> root, int n) {
		if(root == null) {
			return null;
		}
		return nextLarger(root, n , null);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeNode<Integer> root = takeInput(sc);
		TreeNode<Integer> ans = nextLarger(root, n);
		System.out.println((ans != null) ? ans.data : "null");
		sc.close();
	}

}
