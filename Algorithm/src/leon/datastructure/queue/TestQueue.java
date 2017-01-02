package leon.datastructure.queue;

public class TestQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue q = new Queue();
		System.out.println(q.deQueue());
		q.enQueue("string1");
		System.out.println(q.deQueue());
	}

}
