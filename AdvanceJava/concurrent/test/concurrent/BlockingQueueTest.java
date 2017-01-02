package test.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
		for (int i = 0; i < 2; i++) {
			new Thread() {
				public void run() {
					while (true) {
						try {
							Thread.sleep((long) (Math.random() * 1000));
							System.out.println(Thread.currentThread().getName()
									+ "going to put data!");
							queue.put(1);
							System.out.println(Thread.currentThread().getName()
									+ " put data done, q size:" + queue.size());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		}

		new Thread() {
			public void run() {
				while (true) {
					try {
						// try sleep 100 or 1000
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()
								+ "going to take data");
						queue.take();
						System.out.println(Thread.currentThread().getName()
								+ "put data done, q size:" + queue.size());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}.start();
	}
}
