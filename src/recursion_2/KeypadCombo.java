package recursion_2;

import java.util.Scanner;

public class KeypadCombo {
	
	//TODO: Complete this by both methods!
	
	private static void printKeyPadCombo(int num, String output) {
		if(num == 0) {
			System.out.println(output);
			return;
		}
		int n = num % 10;
		String[] choices = helper(n);
		for(int i = 0; i < choices.length; i++) {
			printKeyPadCombo(num / 10, choices[i] + output);
		}
	}
	
	public static void printKeyPadCombo(int n) {
		printKeyPadCombo(n, "");
	}
	
	public static String[] keypadCombo(int num) {
		if(num == 0) {
			String[] ans = {""};
			return ans;
		}
		String[] smallAns = keypadCombo(num / 10);
		String[] choices = helper(num % 10);
		String[] ans = new String[smallAns.length * choices.length];
		
		int k = 0;
		
		for(int i = 0; i < smallAns.length; i++) {
			for(int j = 0; j < choices.length; j++) {
				ans[k] = smallAns[i] + choices[j];
				k++;
			}
		}
		
		return ans;
	}
	
	private static String[] helper(int n) {
		if(n==0 || n==1) {
			String[] ans= {""};
			return ans;
		}

		else if(n==2) {
			String[] ans= {"a","b","c"};
			return ans;
		}
		else if(n==3) {
			String[] ans= {"d","e","f"};
			return ans;
		}
		else if(n==4) {
			String[] ans= {"g","h","i"};
			return ans;
		}
		else if(n==5) {
			String[] ans= {"j","k","l"};
			return ans;
		}
		else if(n==6) {
			String[] ans= {"m","n","o"};
			return ans;
		}
		else if(n==7) {
			String[] ans= {"p","q","r","s"};
			return ans;
		}
		else if(n==8) {
			String[] ans= {"t","u","v"};
			return ans;
		}
		else if(n==9) {
			String[] ans= {"w","x","y","z"};
			return ans;
		}
		return null;
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println("By returning!");
		String[] ans = keypadCombo(n);
		for(int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		System.out.println("By printing!");
		printKeyPadCombo(n);
		sc.close();
	}

}
