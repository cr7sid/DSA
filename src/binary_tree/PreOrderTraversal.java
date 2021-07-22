package binary_tree;

public class PreOrderTraversal {

	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		preOrder(root);
	}

}
