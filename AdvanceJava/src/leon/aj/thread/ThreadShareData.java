package leon.aj.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadShareData {

	private static int data = 0;
	private static Map<Thread,Integer> dataMap = new HashMap<Thread,Integer>();
	
	public static void main(String[] args) {
		for(int i=0;i<3;i++){
			new Thread(new Runnable(){
				public void run(){
					int mydata = new Random().nextInt(99);
					System.out.println(Thread.currentThread().getName()+"make data:"+mydata);
					dataMap.put(Thread.currentThread(), mydata);
					new A().get();
					new B().get();
				}
			}).start();
		}
		
	}
	
	static class A{
		public void get(){
			data = dataMap.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+"A:"+data);
		}
	}
	static class B{
		public void get(){
			data = dataMap.get(Thread.currentThread());
			System.out.println(Thread.currentThread().getName()+"B:"+data);
		}
	}
}
