package binary_tree;

public class InorderTraversal {

	public static void inOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		inOrder(root);
	}

}
