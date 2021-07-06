package recursion_2;

import java.util.Scanner;

public class ReplaceX {

	public static String replaceX(String str) {
		if(str.length() <= 0) {
			return str;
		}
		String ans = "";
		if(str.charAt(0) != 'x' && str.charAt(0) != 'X') {
			ans += str.charAt(0);
		}
		return ans + replaceX(str.substring(1));
	}
	
	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		String ans = replaceX(str);
		System.out.print(ans);
		sc.close();
	}

}
