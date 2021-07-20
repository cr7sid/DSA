package tree;

public class PreorderTraversal {
	
	public static void preorderTraversal(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		for(int i = 0; i < root.children.size(); i++) {
			preorderTraversal(root.children.get(i));
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		preorderTraversal(root);
	}
}
