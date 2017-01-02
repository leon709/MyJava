package leon.algorithm;

public class Calculate {

	
	public static void main(String[] args) {
		String s = "12af";
		System.out.println(getInt(s));
		System.out.println(Integer.parseInt(s,16));
	}

	public static int getInt(String str) {
		int len = str.length();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			char c = str.charAt(len - 1 - i);
			int n = Character.digit(c, 16);
			sum += n * (1 << (4 * i));
		}
		return sum;
	}
}
