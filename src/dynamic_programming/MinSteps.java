package dynamic_programming;

public class MinSteps {
	
	public static int minSteps(int n) {
		if(n == 1) {
			return 1;
		}
		int op1 = minSteps(n - 1);
		int min = op1;
		if(n % 2 == 0) {
			int op2 = minSteps(n / 2);
			if(op2 < min) {
				min = op2;
			}
		}
		if(n % 3 == 0) {
			int op3 = minSteps(n / 3);
			if(op3 < min) {
				min = op3;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		int n = 10;
		System.out.print(minSteps(n));
		
	}

}
