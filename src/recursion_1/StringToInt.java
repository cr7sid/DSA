package recursion_1;

import java.util.Scanner;

public class StringToInt {
	
	public static int stringToInt(String str) {
		int n = str.length();
		if(n <= 0) {
			return 0;
		}
		int val = str.charAt(0) - 48;
		int valWithPlace = (int) (val * Math.pow(10, n - 1));
		return valWithPlace + stringToInt(str.substring(1));
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		int ans = stringToInt(str);
		System.out.print(ans);
		sc.close();
	}

}
