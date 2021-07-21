package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IdenticalTrees {
	
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
	
	static boolean ans = true;
	
	public static boolean identicalTrees(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		if(root1 == null || root1 == null) {
			return false;
		}
		int rootData1 = root1.data;
		int rootData2 = root2.data;
		if((root1.children.size() != root2.children.size()) || rootData1 != rootData2) 
			ans = false;
		for(int i = 0; i < root1.children.size(); i++) {
			ans = identicalTrees(root1.children.get(i), root2.children.get(i));
			if(ans == false) {
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("First tree input");
		TreeNode<Integer> root1 = takeInput(sc);
		System.out.println("Second tree input");
		TreeNode<Integer> root2 = takeInput(sc);
		boolean ans = identicalTrees(root1, root2);
		System.out.println(ans);
	}

}
