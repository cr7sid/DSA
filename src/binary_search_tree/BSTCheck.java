package binary_search_tree;

import binary_tree.BinaryTreeNode;
import binary_tree.BinaryTreeUse;
import binary_tree.Pair;

public class BSTCheck {

	private static int maximum(BinaryTreeNode<Integer> root) {
		if (root == null)
			return Integer.MIN_VALUE;
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}

	private static int minimum(BinaryTreeNode<Integer> root) {
		if (root == null)
			return Integer.MAX_VALUE;
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}

	public static Pair<Boolean, Pair<Integer, Integer>> isBST3(BinaryTreeNode<Integer> root) {
		/*
		 * In this algorithm the time complexity is (n) as we go to every node and
		 * perform constant amount of work.
		 * Here we return a pair of values to the caller so that we won't have to repeat
		 * the same work.
		 */
		if(root == null) {
			Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
			output.first = true;
			output.second.first = Integer.MAX_VALUE;
			output.second.second = Integer.MIN_VALUE;
			return output;
		}
		Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST3(root.left);
		Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST3(root.right);
		int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
		int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
		boolean isBST = (root.data > leftOutput.second.first)
				&& (root.data <= rightOutput.second.second)
				&& leftOutput.first && rightOutput.first;
		Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
		output.first = isBST;
		output.second.first = min;
		output.second.second = max;
		return output;
	}

	public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) {
		/*
		 * In this algorithm the time complexity is (n) as we go to every node and
		 * perform constant amount of work.
		 * Here we maintain two vaiables min and max to compare the value of nodes
		 * in left and right subtree.
		 */
		if (root == null)
			return true;
		if (root.data < min || root.data > max)
			return false;
		boolean isLeftOk = isBST3(root.left, min, root.data - 1);
		boolean isRightOk = isBST3(root.left, root.data, max);
		return isLeftOk && isRightOk;
	}

	public static boolean isBST(BinaryTreeNode<Integer> root) {
		/*
		 * In this algorithm the time complexity is (n * h) as we go to every node and
		 * find corresponding max and min values.
		 */
		if (root == null)
			return true;
		int leftMax = maximum(root.left);
		int rightMin = minimum(root.right);
		if (leftMax >= root.data || rightMin < root.data)
			return false;
		boolean isLeftBST = isBST(root.left);
		boolean isRightBST = isBST(root.right);
		return isLeftBST && isRightBST;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		System.out.println(isBST(root));
	}

}
