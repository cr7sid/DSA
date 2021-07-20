package tree;

public class CountNodes {
	
	public static int countNodes(TreeNode<Integer> root) {
		if(root == null) {
			//This is not a base case. This is edge case, it will be called in case user sends null tree.
			return 0;
		}
		int count = 1;
		for(int i = 0; i < root.children.size(); i++) {
			count += countNodes(root.children.get(i));
		}
		return count;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		int numOfNodes = countNodes(root);
		System.out.println("Number of nodes:" + numOfNodes);
	}

}
