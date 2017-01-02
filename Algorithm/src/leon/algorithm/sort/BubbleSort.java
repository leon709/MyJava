package leon.algorithm.sort;

import java.util.Random;

public class BubbleSort {
	public static void main(String[] str){
		Random rd = new Random();
		int[] a = new int[10];
		for(int i=0;i<a.length;i++){
			a[i]=rd.nextInt(100);
			System.out.print(a[i]+" ");
		}
		
		System.out.println();
		
		bubbleSort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");;
		}
		
		System.out.println();
		
		System.out.println(getMin(a)+" "+getMax(a));
	}
	
	public static void bubbleSort(int[] a){
		int temp=0;
		for(int i=a.length-1;i>1;i--){
			for(int j=0;j<i;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
	public static int getMax(int[] a){
		int r = a[0];
		for(int i=1;i<a.length;i++){
			if(a[i]>r)
				r=a[i];
		}
		
		return r;
	}
	public static int getMin(int[] a){
		int r = a[0];
		for(int i=1;i<a.length;i++){
			if(a[i]<r)
				r=a[i];
		}
		
		return r;
	}
}
