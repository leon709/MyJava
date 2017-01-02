package leon.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Prime {
	public static void main(String str[]){
		System.out.println(isPrime(11));
		System.out.println(getPrimeArray(40));
	}
	
	public static boolean isPrime(int n){
		boolean r = true;
		if(n>3){
			for(int i=2;i<=Math.sqrt(n);i++){
				if(n%i==0){
					r=false;
					break;
				}
			}
		}
		
		return r;
	}
	
	public static List<Integer> getPrimeArray(int num){
		if(num<2){
			return null;
		}else{
			List<Integer> primeList = new ArrayList<Integer>();
			for(int i=2;i<=num;i++){
				if(isPrime(i)){
					primeList.add(i);
				}
			}
			return primeList;
		}
	}
}
