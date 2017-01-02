package leon.datastructure.list;

import leon.datastructure.Node;

public class TestLinkedList {
	public TestLinkedList(){
		Node first=null;
		for(int i=1;i<=5;i++){
			String data = String.valueOf(i);
			first = new Node(data,first);
		}
		while(first != null){
			System.out.println(first.getData());
			first = first.getNext();
		}
	}
	
	@SuppressWarnings("rawtypes")
	java.util.LinkedList l;
}
