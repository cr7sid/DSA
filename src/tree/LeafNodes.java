package tree;

public class LeafNodes {
	
	public static int leafNodes(TreeNode<Integer> root) {
		if(root == null) {
			return -1;
		}
		if(root.children.size() == 0) {
			return 1;
		}
		int count = 0;
		for(int i = 0; i < root.children.size(); i++) {
			count += leafNodes(root.children.get(i));
		}
		return count;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		int leaves = leafNodes(root);
		System.out.println(leaves);
	}

}
