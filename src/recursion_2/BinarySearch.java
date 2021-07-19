package recursion_2;

import java.util.Scanner;

public class BinarySearch {

	public static int search(int[] arr, int x, int sI, int eI) {
		if(sI > eI) {
			return -1;
		}
		
		int midPos = (sI + eI) / 2;
		int midEle = arr[midPos];
		
		if(x == midEle) {
			return midPos;
		} else if(x < midEle) {
			return search(arr, x, 0, midPos - 1);
		} else {
			return search(arr, x, midPos + 1, eI);
		}
	}
	
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int x;
		x = sc.nextInt();
		System.out.print(search(arr, x, 0, n - 1));
		sc.close();
	}

}
