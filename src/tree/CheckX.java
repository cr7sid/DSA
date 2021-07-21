package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckX {
	
	static boolean ans = false;
	
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
	
	public static boolean checkX(TreeNode<Integer> root, int x) {
		if(root == null) {
			return false;
		}
		if(root.data == x) {
			ans = true;
		}
		for(int i = 0; i < root.children.size(); i++) {
			ans = checkX(root.children.get(i), x);
			if(ans == true)
				break;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x");
		int x = sc.nextInt();
		TreeNode<Integer> root = takeInput(sc);
		boolean check = checkX(root, x);
		System.out.println(check);
		sc.close();
	}

}
