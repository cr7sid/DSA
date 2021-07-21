package tree;

public class NodeToDepth {
	
	private static void nodeToDepth(TreeNode<Integer> root, int count) {
		root.data = count;
		for(int i = 0; i < root.children.size(); i++) {
			nodeToDepth(root.children.get(i), count + 1);
		}
	}
	
	public static void nodeToDepth(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		nodeToDepth(root, 0);
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		nodeToDepth(root);
		TreeUse.printLevelWise(root);
	}

}
