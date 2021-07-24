package binary_tree;

public class BalancedBinaryTree {

	private static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int height = 0;
		int height1 = height(root.left);
		int height2 = height(root.right);
		if (height1 > height2) {
			height = height1;
		} else {
			height = height2;
		}
		return height + 1;
	}

	private static boolean isBalanced(BinaryTreeNode<Integer> root, boolean ans) {
		if (root == null) {
			return true;
		}
		if (ans == false) {
			return false;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		if ((lh - rh == 0) || (Math.abs(lh - rh) == 1)) {
			ans = isBalanced(root.left, ans);
			ans = isBalanced(root.right, ans);
		} else {
			ans = false;
		}
		return ans;
	}

	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		return isBalanced(root, true);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println(isBalanced(root));
	}

}
