package tree;

public class LargestNode {
	
	public static int largestNode(TreeNode<Integer> root) {
		if(root == null) {
			//This is not a base case. This is edge case, it will be called in case user sends null tree.
			return Integer.MIN_VALUE;
		}
		int ans = root.data;
		for(int i = 0; i < root.children.size(); i++) {
			int childLargest = largestNode(root.children.get(i));
			if(childLargest > ans) {
				ans = childLargest;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		int largest = largestNode(root);
		System.out.println("Largest node:" + largest);	
	}
}
