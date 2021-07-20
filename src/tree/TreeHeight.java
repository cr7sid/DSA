package tree;

public class TreeHeight {
	
	public static int treeHeight(TreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int count = 0;
		for(int i = 0; i < root.children.size(); i++) {
			int h = treeHeight(root.children.get(i));
			if(h > count) {
				count = h;
			}
		}
		return count + 1;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		int h = treeHeight(root);
		System.out.println("Height of the tree:" + h);	
	}

}
