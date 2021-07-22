package binary_tree;

public class CountNodes {
	
	public static int countNodes(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int ans = 1;
		ans += countNodes(root.left);
		ans += countNodes(root.right);
		return ans;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println(countNodes(root));
	}

}
