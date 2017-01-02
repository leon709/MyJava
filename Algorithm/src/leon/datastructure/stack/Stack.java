package leon.datastructure.stack;

public interface Stack {
	public int size();
	
	public void push(Object o);
	public Object pop();
	
	public boolean isEmpty();
	public boolean isFull();
	
	public Object peek();
}
