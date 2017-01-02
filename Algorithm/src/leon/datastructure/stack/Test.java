package leon.datastructure.stack;

import leon.datastructure.Node;

public class Test {

	public static void main(String[] args) {
		//Stack as = new ArrayStackPT();
		Stack as = new LinkedStackPT();
		
		System.out.println(as.isEmpty());
		System.out.println(as.size());
		Node n1 = new Node("A", null);
		Node n2 = new Node("B", null);
		as.push(n1);
		as.push(n2);
		System.out.println(as.size());
		System.out.println(as.peek());
	}

}
