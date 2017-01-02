package leon.aj.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestFuture {

	public static void main(String[] args) throws InterruptedException {
		long l1 = System.currentTimeMillis();
		
		FutureTask<String> ft1 = new FutureTask<String>(new MyTask1());
		new Thread(ft1).start();
		
		System.out.println("other logic 1");
		Thread.sleep(3000);
		
		FutureTask<String> ft2 = new FutureTask<String>(new MyTask1());
		new Thread(ft2).start();
		
		System.out.println("other logic 1");
		Thread.sleep(3000);
		
		try {
			String taskResult = ft1.get();
			System.out.println(taskResult);
			
			String taskResult2 = ft2.get();
			System.out.println(taskResult2);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		long l2 = System.currentTimeMillis();
		System.out.println(l2-l1);
	}
	
}
class MyTask1 implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println("task begin");
		Thread.sleep(1000*10);
		
		System.out.println("task completed");
		
		return "DONE";
	}
	
}