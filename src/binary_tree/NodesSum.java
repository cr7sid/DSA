package binary_tree;

public class NodesSum {
	
	public static int nodesSum(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int sum = 0;
		sum += root.data;
		sum += nodesSum(root.left);
		sum += nodesSum(root.right);
		return sum;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println(nodesSum(root));
	}

}
