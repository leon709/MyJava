package leon.aj.thread;

import java.util.ArrayDeque;

public class Prosumer {
	
	public static void main(String[] args) {
		final Container<String> c = new Container<String>(30);
		Thread pt1 = new Thread(new Producer("p1",c));
		Thread pc1 = new Thread(new Consumer("c1",c));
		Thread pc2 = new Thread(new Consumer("c2",c));
		
		
		pt1.start();
		pc1.start();
		pc2.start();
		
		
	}

}
class Container<E>{
	private int capacity;
	private ArrayDeque<E> deque;
	private int pointer;
	public Container(int capacity){
		this.capacity = capacity;
		this.deque = new ArrayDeque<E>();
	}
	public synchronized boolean add(E e){
		return deque.add(e);
	}
	public synchronized E remove(){
		return deque.poll();
	}
	public synchronized boolean isFull(){
		return deque.size() == capacity;
	}
	public synchronized boolean isEmpty(){
		return deque.isEmpty();
	}
	
	public synchronized int getPointer(){
		return this.pointer;
	}
	public synchronized void setPointer(int p){
		this.pointer = p;
	}
	public synchronized int size(){
		return deque.size();
	}
}
class Producer implements Runnable{
	private int checkFullTimes;
	private String name;
	private Container<String> container;
	
	Producer(String name,Container<String> container){
		this.name = name;
		this.container = container;
	}
	@Override
	public void run() {
		while(true){
			synchronized(container){
				if(container.isFull()){
					System.out.println(name+": container is full!");
					checkFullTimes++;
					if(checkFullTimes==3){
						break;
					}
					try {
						container.wait(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					produce();
					container.notifyAll();
				}
			}
		}
	}
	private void produce(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String prod = name+"-"+container.getPointer();
		container.add(prod);
		System.out.println(name+" produced: "+prod);
		container.setPointer(container.getPointer()+1);
		checkFullTimes=0;
	}
}
class Consumer implements Runnable{
	private int haveCount;
	private String name;
	private Container<String> container;
	
	Consumer(String name,Container<String> container){
		this.name = name;
		this.container = container;
	}
	@Override
	public void run() {
		while(true){
			synchronized(container){
				if(container.isEmpty()){
					System.out.println(name+": container is empty!");
					try {
						container.wait(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					consume();
					container.notifyAll();
					if(haveCount==10){
						System.out.println(name+": Oh, I am full......");
						break;
					}
				}
			}
		}
	}
	private void consume(){
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String prod = container.remove();
		System.out.println(name+" consumed: "+prod);
		//container.setPointer(container.getPointer()-1);
		haveCount++;
	}
}