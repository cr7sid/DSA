package tree;

public class LargestNode {
	
	public static TreeNode<Integer> largestNode(TreeNode<Integer> root) {
		if(root == null) {
			//This is not a base case. This is edge case, it will be called in case user sends null tree.
			return null;
		}
		TreeNode<Integer> ans = root;
		for(int i = 0; i < root.children.size(); i++) {
			TreeNode<Integer> childLargest = largestNode(root.children.get(i));
			if(childLargest != null && childLargest.data > ans.data) {
				ans = childLargest;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		TreeNode<Integer> largest = largestNode(root);
		System.out.println("Largest node:" + (largest != null ? largest.data : "null"));	
	}
}
