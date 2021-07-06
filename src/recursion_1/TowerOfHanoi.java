package recursion_1;

import java.util.Scanner;

public class TowerOfHanoi {
	
	public static void towerOfHanoi(int n) {
		if(n == 0) {
			
		}
		if(n == 1) {
			//System.out.print();
		}
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		towerOfHanoi(n);
		sc.close();
	}

}
