package tree;

public class SumOfNodes {
	
	public static int sumOfNodes(TreeNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int sum = root.data;
		for(int i = 0; i < root.children.size(); i++) {
			sum += sumOfNodes(root.children.get(i));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		int sum = sumOfNodes(root);
		System.out.println("Sum of the nodes:" + sum);	
	}

}
