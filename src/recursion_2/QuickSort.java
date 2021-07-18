package recursion_2;

import java.util.Scanner;

public class QuickSort {
	
	public static void quickSort(int[] input, int si, int ei) {
		if(si >= ei) {
			return;
		}
		int pivotPos = partition(input, si, ei);
		quickSort(input, si, pivotPos - 1);
		quickSort(input, pivotPos + 1, ei);
	}
	
	private static int partition(int[] input, int si, int ei) {
		int pivot = input[si];
		int count = si;
		for(int i = si + 1; i <= ei; i++) {
			if(input[i] <= pivot) {
				count++;
			}
		}
		int temp = input[count];
		input[count] = pivot;
		input[si] = temp;
		int i = si;
		int j = ei;
		
		while(i < count && j > count) {
			if(input[i] > pivot) {
				if(input[j] <= pivot) {
					int t = input[i];
					input[i] = input[j];
					input[j] = t;
					i++;
					j--;
				} else {
					j--;
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr, 0, n - 1);
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		
		sc.close();
	}

}
