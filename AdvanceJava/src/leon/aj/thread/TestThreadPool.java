package leon.aj.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		int i=0;
		for( i=1; i<=10;i++){
			final int task = i;
			es.execute(new Runnable(){
				@Override
				public void run() {
					for(int i=1;i<=5;i++){
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+" loop "+i+" task "+task);
					}
				}
			});
		}
		System.out.println(i+"task put to pool");
		es.shutdown();
	}

}
