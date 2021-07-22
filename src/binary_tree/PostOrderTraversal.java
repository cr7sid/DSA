package binary_tree;

public class PostOrderTraversal {

	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		postOrder(root);
	}

}
