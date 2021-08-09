package hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicatesString {

	public static String removeDuplicates(String str) {
		String ans = "";
		HashMap<Character, Boolean> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i)))
				continue;
			map.put(str.charAt(i), true);
			ans += str.charAt(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = removeDuplicates(str);
		System.out.println(str);
		sc.close();
	}

}
