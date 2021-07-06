package recursion_1;

import java.util.Scanner;

public class PairStar {
	
	public static String pairStar(String str) {
		if(str.length() <= 1) {
			return str;
		}
		String ans = "";
		ans += str.charAt(0);
		if(str.charAt(0) == str.charAt(1)) {
			ans += "*";
		}
		return ans + pairStar(str.substring(1));
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		String ans = pairStar(str);
		System.out.print(ans);
		sc.close();
	}
	
}
