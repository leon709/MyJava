package leon.aj.thread;

public class TestThread {

	public static void main(String[] args) {
		final Business b = new Business();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=1;i<=50;i++)
					b.sub(5);
			}
		}).start();
		
		for(int i=1;i<=50;i++)
			b.main(10);
	}

	
}

class Business{
	boolean isMain;
	public synchronized void  sub(int s){
		while(isMain){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		for(int i=1;i<=s;i++){
			System.out.println("sub: "+i);
		}
		isMain = true;
		this.notify();
	}
	public synchronized void  main(int s){
		while(!isMain){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=1;i<=s;i++){
			System.out.println("main: "+i);
		}
		isMain = false;
		this.notify();
	}
}

