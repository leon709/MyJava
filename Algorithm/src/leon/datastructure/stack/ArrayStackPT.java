package leon.datastructure.stack;

import java.io.Serializable;

/**
 * This implementation is based on a static array. Thus, the stack can become full, and then
 * no more items can be pushed.
 * The user can specify the stack's capacity when it is created.
 * @author Leon
 */
public class ArrayStackPT implements Stack,Serializable {
	public static final int DEFAULT_CAPACITY = 100;
	private Object[] stack;							//the array that holds the stack
	private int top;								//index of top item on the stack
	
	public ArrayStackPT(){
		this (DEFAULT_CAPACITY);
	}

	public ArrayStackPT(int capacity) {
		if(capacity < 1){
			throw new IllegalArgumentException("Capacity must be > 0");
		}
		stack = new Object[capacity];
		top=-1;
	}
	
	public boolean isEmpty(){
		return top==-1;
	}
	
	public boolean isFull(){
		return size() == stack.length;
	}

	public int size() {
		return top+1;
	}
	
	public Object pop(){
		if(isEmpty()){
			throw new IllegalStateException("Stack is empty.");
		}
		Object topItem = stack[top];
		stack[top] = null;
		top--;
		return topItem;
	}
	public void push(Object item){
		if(item==null){
			throw new IllegalArgumentException("Item is null");
		}
		if(isFull()){
			throw new IllegalStateException("Stack is full.");
		}
		top++;
		stack[top]=item;
	}

	@Override
	public Object peek() {
		if(isEmpty())
			throw new IllegalStateException("Stack is Empty.");
		return stack[top];
	}
}
