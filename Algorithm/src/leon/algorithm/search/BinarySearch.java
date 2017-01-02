package leon.algorithm.search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

	public static void main(String str[]){
		Random rd = new Random();
		int[] a = new int[20];
		for(int i=0;i<a.length;i++){
			a[i]=rd.nextInt(100);
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		Arrays.sort(a);
		for(int i: a){
			System.out.print(i+" ");
		}
		System.out.println();
		
		System.out.println(binarySearch(70, a));
	}
	
	public static int binarySearch(int target, int[] a){
		int result = -1;
		int left = 0;
		int right = a.length-1;
		
		while(left <= right){
			int mid = (left+right)>>1;
			if(a[mid]==target){
				result = mid;
				break;
			} else if (a[mid]<target){
				left = mid+1;
			}else{
				right = mid-1;
			}
		}
		return result;
	}
}
