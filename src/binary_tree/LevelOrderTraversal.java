package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void levelOrderTraversal(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode<Integer>> primary = new LinkedList<>();
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		primary.add(root);

		while (!primary.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = primary.remove();
			System.out.print(frontNode.data + " ");
			if (frontNode.left != null) {
				pendingNodes.add(frontNode.left);
			}
			if (frontNode.right != null) {
				pendingNodes.add(frontNode.right);
			}
			if(primary.isEmpty()) {
				Queue<BinaryTreeNode<Integer>> temp = pendingNodes;
				pendingNodes = primary;
				primary = temp;
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		levelOrderTraversal(root);
	}

}
