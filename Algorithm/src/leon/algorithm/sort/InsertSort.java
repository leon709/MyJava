package leon.algorithm.sort;

import java.util.Random;

public class InsertSort {

	public static void main(String[] args) {
		Random rd = new Random();
		int[] a = new int[10];
		for(int i=0;i<a.length;i++){
			a[i]=rd.nextInt(100);
			System.out.print(a[i]+" ");
		}
		
		System.out.println();
		
		insertSourt(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");;
		}
	}
	public static void insertSourt(int[] a){
		int in,out;
		for(out=1;out<a.length;out++){
			int temp = a[out];
			in = out;
			while(in>0 && a[in-1] >= temp){
				a[in] = a[in-1];
				--in;
			}
			a[in] = temp;
		}
	}

}
