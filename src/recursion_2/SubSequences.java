package recursion_2;

import java.util.Scanner;

public class SubSequences {
	
	private static void printSubSequence(String str, String output) {
		if(str.length() == 0) {
			System.out.println(output);
			return;
		}
		printSubSequence(str.substring(1), output);
		printSubSequence(str.substring(1), str.charAt(0) + output);
	}
	
	public static void printSubSequence(String str) {
		printSubSequence(str, "");
	}

	public static String[] subSequence(String str) {
		if(str.length() == 0) {
			String[] ans = {""};
			return ans;
		}
		String smallAns[] = subSequence(str.substring(1));
		String ans[] = new String[2 * smallAns.length];
		
		int k = 0;
		for(int i = 0; i < smallAns.length; i++) {
			ans[k] = smallAns[i];
			k++;
		}
		for(int i = 0; i < smallAns.length; i++) {
			ans[k] = str.charAt(0) + smallAns[i];
			k++;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		System.out.println("By returning!");
		String ans[] = subSequence(str);
		for(int i = 0; i < ans.length; i++) 
			System.out.println(ans[i]);
		System.out.println("By printing!");
		printSubSequence(str);
		sc.close();
	}

}
