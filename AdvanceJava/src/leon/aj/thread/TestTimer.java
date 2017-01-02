package leon.aj.thread;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

	public static void main(String[] args) {
		TimerTask task = new MyTask();
		
		Timer timer = new Timer("mytimer");
		timer.schedule(task,5000,3000);
		
		Runnable r = new Runnable(){
			public void run() {
				System.out.println("xdfg");
			}
		};
		Thread t1 = new Thread(r);
		t1.start();
	}

}

class MyTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("test...");
	}
	
}