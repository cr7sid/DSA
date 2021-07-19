package recursion_2;

import java.util.Scanner;

public class Permutations {
	
	//TODO: Try and complete!
	
	public static String[] permutations(String str) {
		if(str.length() == 0) {
			String[] ans = {""};
			return ans;
		}
		
	}
	
	private static void printPermutations(String str, String ans) {
		if(str.length() == 0) {
			System.out.println(ans);
		}
		for(int i = 0; i < str.length(); i++) {
			printPermutations();
		}
	}
	
	public static void printPermutations(String str) {
		printPermutations(str, "");
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		System.out.println("By returning!");
		String ans[] = permutations(str);
		for(int i = 0; i < ans.length; i++) 
			System.out.println(ans[i]);
		System.out.println("By printing!");
		printPermutations(str);
		sc.close();
	}

}
