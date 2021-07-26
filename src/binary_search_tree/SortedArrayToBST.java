package binary_search_tree;

import java.util.Scanner;

import binary_tree.BinaryTreeNode;
import binary_tree.BinaryTreeUse;

public class SortedArrayToBST {
	
	public static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr, int si, int ei) {
		if(si > ei)
            return null;
        int mid = (si + ei + 1) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);
        root.left = sortedArrayToBST(arr, si, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, ei);
        return root;
	}
	
	public static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr) {
		return sortedArrayToBST(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		BinaryTreeNode<Integer> root = sortedArrayToBST(arr);
		BinaryTreeUse.printLevelWise(root);
		sc.close();
	}

}
