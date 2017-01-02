package leon.aj.refrection;

public class TestClass {

	public static void main(String[] args) throws Exception {
		Class<String> c1 = String.class;
		String s = "";
		Class<? extends String> c2 = s.getClass();
		Class<?> c3 = Class.forName("java.lang.String");
		
		System.out.println(c1==c2);		//true
		System.out.println(c1==c3);		//true
		
		System.out.println(int.class.isPrimitive());	//true
		System.out.println(Integer.class.isPrimitive());	//false
		System.out.println(int.class==Integer.class);	//false
		System.out.println(int.class==Integer.TYPE);	//true
		
		System.out.println(int[].class.isPrimitive());	//false
		System.out.println(int[].class.isArray());	//true
	}

}

class MyClassLoader extends ClassLoader{
	
	public void loadClass(){
		
	}
}
