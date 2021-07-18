package recursion_2;

import java.util.Scanner;

public class KeypadCombo {
	
	public static void keypadCombo(int num, String output) {
		if(num == 0) {
			System.out.println(output);
			return;
		}
		int n = num % 10;
		String[] choices = helper(n);
		for(int i = 0; i < choices.length; i++) {
			keypadCombo(num / 10, choices[i] + output);
		}
		
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
		keypadCombo(n, "");
		sc.close();
	}

}
