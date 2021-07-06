package recursion_2;

import java.util.Scanner;

public class ReplaceChar {

	public static String replaceChar(String str, char c1, char c2) { 
		if(str.length() <= 0) {
			return str;
		}
		String ans = "";
		if(str.charAt(0) != c1 && str.charAt(0) != c2) {
			ans += str.charAt(0);
		}
		return ans + replaceChar(str.substring(1), c1, c2);
	}
	 
	public static void main(String[] args) {
		String str;
		char c1, c2;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		c1 = sc.next().charAt(0);
		c2 = sc.next().charAt(0);
		String ans = replaceChar(str, c1, c2);
		System.out.print(ans);
		sc.close();
	}

}
