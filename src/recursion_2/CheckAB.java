package recursion_2;

import java.util.Scanner;

public class CheckAB {

	private static boolean checkAB(String str) {
		if(str.length() == 0) {
			return true;
		}
		if(!str.startsWith("a")) {
			return false;
		}
		if(str.length() >= 3 && str.substring(0, 3).equals("abb")) {
			return checkAB(str.substring(3));
		}
		return checkAB(str.substring(1));
	}
	
	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		System.out.print(checkAB(str));
		sc.close();
	}

}
