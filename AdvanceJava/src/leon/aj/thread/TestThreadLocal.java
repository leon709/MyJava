package leon.aj.thread;

import java.util.Random;

public class TestThreadLocal {

	private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
	
	public static void main(String[] args) {
		for(int i=0;i<3;i++){
			new Thread(new Runnable(){
				public void run(){
					int mydata = new Random().nextInt(99);
					System.out.println(Thread.currentThread().getName()+"make data:"+mydata);
					tl.set(mydata);
					
					ShareData.getThreadInstance().setName(Thread.currentThread().getName());
					ShareData.getThreadInstance().setValue(mydata);
					
					new A().get();
					new B().get();
				}
			}).start();
		}
		
	}
	
	static class A{
		public void get(){
			int data = tl.get();
			System.out.println(Thread.currentThread().getName()+" A:"+data +" "+ShareData.getThreadInstance());
		}
	}
	static class B{
		public void get(){
			int data = tl.get();
			System.out.println(Thread.currentThread().getName()+" B:"+data +" "+ShareData.getThreadInstance());
		} 
	}

}

class ShareData{
	private String name;
	private int value;
	
	private ShareData(){};
	
	private static ThreadLocal<ShareData> shareDataMap = new ThreadLocal<ShareData>();
	
	public static ShareData getThreadInstance(){
		ShareData shareData = shareDataMap.get();
		
		if(shareData == null){
			shareData = new ShareData();
			shareDataMap.set(shareData);
		}
		return shareData;
	}
	
	public String toString(){
		return name+"->"+value;
	}
	
	//getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
