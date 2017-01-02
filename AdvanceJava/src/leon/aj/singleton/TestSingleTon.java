package leon.aj.singleton;

public class TestSingleTon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleTon1 s1 = SingleTon1.getInstance();
		SingleTon1 s2 = SingleTon1.getInstance();
		System.out.println(s1==s2);
		
		SingleTon2 s3 = SingleTon2.getInstance();
		SingleTon2 s4 = SingleTon2.getInstance();
		System.out.println(s3==s4);
		
		SingleTon3 s5 = SingleTon3.getInstance();
		SingleTon3 s6 = SingleTon3.getInstance();
		System.out.println(s5==s6);
		
		SingleTon4 s7 = SingleTon4.getInstance();
		SingleTon4 s8 = SingleTon4.getInstance();
		System.out.println(s7==s8);
		
		SingleTon5 s9 = SingleTon5.getInstance();
		SingleTon5 s10 = SingleTon5.getInstance();
		System.out.println(s9==s10);
	}

}
