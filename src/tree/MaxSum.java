package tree;

public class MaxSum {
	
	static int ans;
	static int maxSum;
	
	private static void maxSum(TreeNode<Integer> root) {
		if(root == null)
			return;
		int sum = root.data;
		for(int i = 0; i < root.children.size(); i++) {
			sum += root.children.get(i).data;
			maxSum(root.children.get(i));
		}
		if(sum > maxSum) {
			maxSum = sum;
			ans = root.data;
		}
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		maxSum(root);
		System.out.println(ans);
	}

}
