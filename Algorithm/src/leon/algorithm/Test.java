package leon.algorithm;

import java.util.Date;

public class Test extends Date{

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Permutation p= new Permutation();
		
		//	System.out.println(p.str); // not visible
		new Test().test();
		
		StringBuffer s = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		
		System.out.println(new Test().testFinallyReturn());//0
		
	}
	
	public void test(){
		System.out.println(super.getClass().getName());
		System.out.println(Test.class.getSuperclass().getName());
	}

	public int testFinallyReturn(){
		int x=0;
		try{
			//System.out.println(23 / x);
			//throw new Exception();
			return x;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("finally..");
			x++;
		}
		
		System.out.println("testing");//will not execute code here
		return x;
	}
	
	
}


