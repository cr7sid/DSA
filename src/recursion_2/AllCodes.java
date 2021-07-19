package recursion_2;

import java.util.Scanner;

public class AllCodes {
	
	public static String[] allCodes(String str) {
		if(str.length() == 0) {
			String[] ans = {""};
			return ans;
		}
		String[] smallAns = allCodes(str.substring(1));
		char c = (char) ((Integer.valueOf(str.charAt(0) - '0')) + 96);
		for(int i = 0; i < smallAns.length; i++) {
			smallAns[i] = c + smallAns[i];
		}
		String[] smallAns1 = new String[0];
		if(str.length() >= 2) {
			char c1 = (char) ((Integer.valueOf(str.charAt(0) - '0') * 10) + (Integer.valueOf(str.charAt(1) - '0')) + 96);
			if(c1 >= 'a' && c1 <= 'z') {
				smallAns1 = allCodes(str.substring(2));
				for(int i = 0; i < smallAns1.length; i++) {
					smallAns1[i] = c1 + smallAns1[i];
				}
			}
		}
		String[] ans = new String[smallAns.length + smallAns1.length];
		for(int i = 0; i < smallAns.length; i++) {
			ans[i] = smallAns[i];
		}
		for(int i = smallAns.length; i < ans.length; i++) {
			ans[i] = smallAns1[i - smallAns.length];
		}
		return ans;
 	}
	
	public static void printAllCodes(String str) {	
		printAllCodes(str, "");
	}

	private static void printAllCodes(String str, String ans) {
		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		char c = (char) ((Integer.valueOf(str.charAt(0) - '0')) + 96);
		printAllCodes(str.substring(1), c + ans);
		if(str.length() >= 2) {
			char c1 = (char) ((Integer.valueOf(str.charAt(0) - '0') * 10) + (Integer.valueOf(str.charAt(1) - '0')) + 96);
			if(c1 >= 'a' && c1 <= 'z')
				printAllCodes(str.substring(2), c1 + ans);
		}
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		System.out.println("By returning!");
		String[] ans = allCodes(str);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		System.out.println("By printing!");
		printAllCodes(str);
		sc.close();
	}

}
