package leon.aj.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {
	public static void main(String[] args) {
		ExecutorService  es = Executors.newSingleThreadExecutor();
		Future<String> futureResult = es.submit(new Callable<String>(){

			@Override
			public String call() throws Exception {
				Thread.sleep(3000);
				
				return "hello";
			}
			
		});
		
		while(true){
			String result="";
			try {
				result = futureResult.get();//this will make the current thread wait until get the return result
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
			if("hello".equals(result)){
				System.out.println("get result:"+result);
				break;
			}else{
				System.out.println("waiting...");
			}
		}
		
		
		es.shutdown();
	}

}
