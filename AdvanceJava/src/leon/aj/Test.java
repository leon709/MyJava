package leon.aj;


public class Test {

	public static int a;
	
	public static void main(String[] args) {
		int x=33;
		int y=1;
		if(x==33 & ++y>0) {
			System.out.println(y);
		}

		System.out.println(Test.class.getClassLoader().getClass().getName());			//App
		System.out.println(Test.class.getClassLoader().getParent().getClass().getName());//Ext
		System.out.println(Test.class.getClassLoader().getParent().getParent());//null
		
		a=1;
		
		MyThread t1 = new MyThread("t1",3);
		MyThread t2 = new MyThread("t2",4);
		t1.start();
		t2.start();
	}

	public static synchronized int testForThread(int i,String name){
		a=i;
		try {
			System.out.println(name);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return a;
	}
}

class MyThread extends Thread{
	String name;
	int a;
	public MyThread(String name,int a){
		this.name = name;
		this.a = a;
	}
	public void run(){
		System.out.print(name+":");
		System.out.println(Test.testForThread(a,name));
	}
}