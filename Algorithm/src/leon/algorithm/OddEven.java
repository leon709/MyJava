
package leon.algorithm;

public class OddEven {

	public static void main(String str[]){
		System.out.println(isOdd(3));
		System.out.println(isOdd(8));
		System.out.println(isEven(3));
		System.out.println(isEven(8));
	}

	public static boolean isOdd(int i) {
		return (i&1)==1;
	}
	public static boolean isEven(int i) {
		return (i&1)!=1;
	}
}
