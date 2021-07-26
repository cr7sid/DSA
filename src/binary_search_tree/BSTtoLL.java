package binary_search_tree;

import java.util.LinkedList;

import binary_tree.BinaryTreeNode;
import binary_tree.BinaryTreeUse;
import binary_tree.Pair;

public class BSTtoLL {
	
	public static Pair<LinkedList<Integer>, LinkedList<Integer>> bstToLL(BinaryTreeNode<Integer> root) {
		if(root == null) {
			Pair<LinkedList<Integer>, LinkedList<Integer>> output = new Pair<>();
			output.first = null;
			output.second = null;
			return output;
		}
		Pair<LinkedList<Integer>, LinkedList<Integer>> leftOutput = bstToLL(root.left);
		Pair<LinkedList<Integer>, LinkedList<Integer>> rightOutput = bstToLL(root.right);
		Pair<LinkedList<Integer>, LinkedList<Integer>> output = new Pair<>();
		output.first = leftOutput.first;
		output.second = rightOutput.second;
		return output;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		LinkedList<Integer> ll = bstToLL(root).first;
		for(int i = 0; i < ll.size(); i++) {
			System.out.print(ll.get(i) + " ");
		}
	}

}
