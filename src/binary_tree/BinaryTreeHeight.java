package binary_tree;

public class BinaryTreeHeight {
	
	public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) {
			return 0;
		}
		int height = 0;
		int height1 = height(root.left);
		int height2 = height(root.right);
		if(height1 > height2) {
			height = height1;
		} else {
			height = height2;
		}
		return height + 1;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println("Height of binary tree:" + height(root));
	}

}
