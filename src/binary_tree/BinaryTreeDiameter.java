package binary_tree;

public class BinaryTreeDiameter {
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int option1 = height(root.left) + height(root.right);
		int option2 = diameter(root.left);
		int option3 = diameter(root.right);
		return Math.max(option1, Math.max(option2, option3));
	}
	
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + Math.max(lh, rh);
	}
	
	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root) {
		//Pair - first = height, second = diameter.
		if(root == null) {
			Pair<Integer, Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair<Integer, Integer> lo = heightDiameter(root.left);
		Pair<Integer, Integer> ro = heightDiameter(root.right);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int height = 1 + Math.max(lo.first, ro.first);
		int diameter = Math.max(option1, Math.max(option2, option3));
		Pair<Integer, Integer> output = new Pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println(heightDiameter(root).second);
	}
}
