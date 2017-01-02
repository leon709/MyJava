package leon.aj.thread;

public class ProducerConsumer {
	public static int value; 
	public static int size = 5;
	public static void main(String[] args) {
		final ProducerConsumer t = new ProducerConsumer(); 
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					t.produce();
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				while(true){
					t.consume();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public synchronized void produce(){
		if(value==size){
			System.out.println("full");
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			value++;
			System.out.println("produce"+value);
		}
	}
	
	public synchronized void consume(){
		if(value==0){
			System.out.println("empty");
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			value--;
			System.out.println("consume"+value);
		}
	}
}
