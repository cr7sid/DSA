package binary_tree;

public class BTMirror {
	
	public static void mirror(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		BinaryTreeNode<Integer> temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		mirror(root);
		BinaryTreeUse.printLevelWise(root);
	}

}
