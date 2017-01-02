package leon.aj.annotation;

@MyAnnotation(color="red",value="abc")
public class Test {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		MyBean b = new MyBean();
		
		b.sayHello();
		
		//System.runFinalizersOnExit(true);
		//MyAnnotation ma = ()
	}

}
