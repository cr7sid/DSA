package recursion_2;

import java.util.Scanner;

public class SubSequences {

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
		String ans[] = subSequence(str);
		for(int i = 0; i < ans.length; i++) 
			System.out.println(ans[i]);
		sc.close();
	}

}
