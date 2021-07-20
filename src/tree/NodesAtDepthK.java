package tree;

public class NodesAtDepthK {
	
	public static void nodesAtDepthK(TreeNode<Integer> root, int k) {
		if(k < 0) {
			return;
		}
		if(k == 0) {
			System.out.println(root.data);
			return;
		}
		for(int i = 0; i < root.children.size(); i++) {
			nodesAtDepthK(root.children.get(i), k - 1);
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUse.takeInputLevelWise();
		int k = 2;
		nodesAtDepthK(root, k);
	}

}
