package recursion_1;

import java.util.Scanner;

public class GeoSum {
	 
	public static double geoSum(int k) {
		if(k == 0) {
			return 1;
		}
		return (1 / Math.pow(2, k)) + geoSum(k - 1);
	}

	public static void main(String[] args) {
		int k;
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		double ans = geoSum(k);
		System.out.print(ans);
		sc.close();
	}

}
