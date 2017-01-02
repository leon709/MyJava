package leon.datastructure.queue;

public class Queue {

	private int front;
	private int back;
	private int size;
	private Object[] elements;

	public Queue() {
		elements = new Object[10];
	}

	public int getSize() {
		return size;
	}
	
	public Object deQueue() {
		Object o = null;
		if (size > 0) {
			size--;
			o = elements[front];
			elements[front] = null;
			front = (front > elements.length - 1) ? 0 : front + 1;
		}
		return o;
	}
	
	public void enQueue(Object o) {
		if (size >= elements.length) {
			Object[] newElements = new Object[elements.length * 2];
			for (int i = 0; i < elements.length; ++i) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}
		elements[back] = o;
		back++;
		size++;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < elements.length; i++) {
			Object o = elements[i];
			if (o != null) {
				str.append(o + " ");
			}
		}
		return str.toString();
	}
}
