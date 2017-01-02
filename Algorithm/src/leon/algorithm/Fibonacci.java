package leon.algorithm;

public class Fibonacci {

	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			System.out.print(getFibonacci(i)+" ");
		}
		System.out.println();
		for(int i=0;i<20;i++){
			System.out.print(f(i)+" ");
		}
	}
	
	public static int getFibonacci(int n){
		int first = 0;
		int second = 1;
		int febonacci = 0;
		if(n==1){
			febonacci=1;
		}else if(n>1){
			int a=first;
			int b=second;
			for(int i=1;i<n;i++){
				febonacci=a+b;
				a=b;
				b=febonacci;
			}
		}
		return febonacci;
	}

	public static int f(int n){
		int feb = 0;
		if(n==0){
			feb = 0;
		}else if(n==1){
			feb = 1;
		}else if(n>1){
			feb = f(n-1)+f(n-2);
		}
		return feb;
	}
}
