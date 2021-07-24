package binary_tree;

public class NodesWithoutSibling {

	public static void nodesWithoutSibling(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		if (root.left != null && root.right != null) {
			nodesWithoutSibling(root.left);
			nodesWithoutSibling(root.right);
		} else if (root.left != null) {
			System.out.println(root.left.data);
			nodesWithoutSibling(root.left);
		} else if (root.right != null) {
			System.out.println(root.right.data);
			nodesWithoutSibling(root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		nodesWithoutSibling(root);
	}

}
