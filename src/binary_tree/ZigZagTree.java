package binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTree {
	
	public static List<List<Integer>> zigzagTree(BinaryTreeNode<Integer> root) {
		List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
			return list;
		}
		Queue<BinaryTreeNode<Integer>> primary = new LinkedList<>();
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		int i = 1;
		primary.add(root);
        List<Integer> list1 = new ArrayList<>();

		while (!primary.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = primary.remove();
            list1.add(frontNode.data);
				if (frontNode.left != null) {
					pendingNodes.add(frontNode.left);
				}

				if (frontNode.right != null) {
					pendingNodes.add(frontNode.right);
				}
			
			if(primary.isEmpty()) {
				Queue<BinaryTreeNode<Integer>> temp = pendingNodes;
				pendingNodes = primary;
				primary = temp;
                if(i % 2 == 0) {
                    Collections.reverse(list1);
                }
				i++;
                list.add(list1);
                list1 = new ArrayList<>();
			}
		}
        return list;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInputLevelWise();
		List<List<Integer>> list = zigzagTree(root);
		for(List<Integer> ans : list) {
			for(int x : ans) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

}
