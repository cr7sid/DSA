package recursion_1;

import java.util.Scanner;

public class ReplacePI {
	
	public static String replacePI(String str) {
		if(str.length() <= 1) {
			return str;
		}
		String ans = "";
		if(str.charAt(0) == 'p' && str.charAt(1) == 'i') {
			ans += "3.14";
			return ans + replacePI(str.substring(2));
		}
		ans += str.charAt(0);
		return ans + replacePI(str.substring(1));
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		String ans = replacePI(str);
		System.out.print(ans);
		sc.close();
	}

}
