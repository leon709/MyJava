package leon.datastructure;

import leon.datastructure.stack.ArrayStackPT;

public class WordReverse {
	
	public static void main(String[] args) {
		WordReverse wr = new WordReverse();
		System.out.println(wr.doReverse("Good Luck!"));
	}

	public String doReverse(String word){
		ArrayStackPT st = new ArrayStackPT();
		char[] ca = word.toCharArray();
		for(char c : ca){
			st.push(c);
		}
		
		String output = "";
		while(!st.isEmpty()){
			output+=st.pop();
		}
		return output;
	}
}
