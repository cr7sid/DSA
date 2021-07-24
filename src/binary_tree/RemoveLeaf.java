package binary_tree;

public class RemoveLeaf {

	public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if(root.left == null && root.right == null) {
			return null;
		}
		BinaryTreeNode<Integer> left = removeLeaf(root.left);
		BinaryTreeNode<Integer> right = removeLeaf(root.right);
		if(left == null)
			root.left = null;
		if(right == null) {
			root.right = null;
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		BinaryTreeUse.printLevelWise(removeLeaf(root));
	}

}
