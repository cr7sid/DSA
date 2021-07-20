package tree;

public class NodesGreaterThanX {
	
	public static int nodesGreaterThanX(TreeNode<Integer> root, int  x) {
		if(root == null) {
			return -1;
		}
		int count = 0;
		if(root.data > x)
			count++;
		for(int i = 0; i < root.children.size(); i++) {
			count += nodesGreaterThanX(root.children.get(i), x);
		}
		return count;
	}

	public static void main(String[] args) {
		int x = 10;
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		int ans = nodesGreaterThanX(root, x);
		System.out.println(ans);
	}

}
