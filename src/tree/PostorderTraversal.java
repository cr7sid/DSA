package tree;

public class PostorderTraversal {

	public static void postorderTraversal(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		for(int i = 0; i < root.children.size(); i++) {
			postorderTraversal(root.children.get(i));
		}
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		postorderTraversal(root);
	}

}
