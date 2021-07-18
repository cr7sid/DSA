package recursion_2;

import java.util.Scanner;

public class MergeSort {

	public static void mergeSort(int[] input, int si, int ei) {
		if(si >= ei) {
			return;
		}
		int mid = ((si + ei) / 2);
		mergeSort(input, si, mid);
		mergeSort(input, mid + 1, ei);
		merge(input, si, ei);
	}
	
	private static void merge(int[] input, int si, int ei) {
		int[] output = new int[ei - si + 1];
		int mid = (si + ei) / 2;
		int i = si;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= ei) {
			if(input[i] < input[j]) {
				output[k] = input[i];
				i++;
				k++;
			} else {
				output[k] = input[j];
				j++;
				k++;
			}
		}
		while(i <= mid) {
			output[k] = input[i];
			i++;
			k++;
		}
		while(j <= ei) {
			output[k] = input[j];
			j++;
			k++;
		}
		for(int index = 0; index < output.length; index++) {
			input[si + index] = output[index];
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
		mergeSort(arr, 0, n - 1);
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		
		sc.close();
	}

}
