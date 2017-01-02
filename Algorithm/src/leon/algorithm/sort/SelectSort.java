package leon.algorithm.sort;

import java.util.Random;

public class SelectSort {
	public static void main(String str[]){
		Random rd = new Random();
		int[] a = new int[10];
		for(int i=0;i<a.length;i++){
			a[i]=rd.nextInt(100);
			System.out.print(a[i]+" ");
		}
		
		System.out.println();
		
		selectSort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");;
		}
	}
	
	public static void selectSort(int[] a){
		int j,i,min,temp;
		for(j=0;j<a.length-1;j++){
			min=j;
			for(i=j+1;i<a.length;i++){
				if(a[i]<a[min])
					min=i;
			}
			if(min !=j){
				temp = a[j];
				a[j]=a[min];
				a[min]=temp;
			}
		}
	}
	
}
