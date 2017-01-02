package leon.algorithm;

public class Factorial {
	public static void main(String str[]){
		System.out.println(getFactorial(5));
		System.out.println(getFactorialSum(5));
	}
	
	/**
	 * 循环实现
	 * @param a
	 * @return
	 */
	public static int getFactorial(int a){
		int f=1;
		for(int i=1;i<=a;i++){
			f*=i;
		}
		return f;
	}
	
	/**
	 * 递归实现
	 * @param n
	 * @return
	 */
	private static int getFactorialSum(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return getFactorialSum(n - 1) * n;
		}
	}
}
