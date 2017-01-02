package leon.algorithm;

import java.util.Arrays;

/**
 * @author 123
 * 20 个人围成一圈，标号1~20。然后从1号开始，向右手边1至3报数，报到3的出列，下一个又从1开始报到3出列，
 * 直到最后一个人出列结束。求标号的出列顺序，如本题应为：3,6,9,12,15,18,1.....
 */
public class JosephCircle {
	
	/**
	 * @author MK
	 * 算法思路：每个人挂一个标志位，初始都为false，循环下，如果出列了就设为true。一个报数器和指针变量，
	 * 每报到3时，指针指向谁谁就出列。
	 */
	public void josephCircle(int n,int k){
		int flag=0;
		boolean[] kick = new boolean[n];
		//set kick flag to False;
		//for(int i=0;i<n-1;i++){
		//	kick[flag]=false;
		//}
		int counter=0;
		int accumulate=0;
		while(true){
			if(!kick[flag]){
				accumulate++;
				if(counter==n-1){
					System.out.println("kick last person===="+(flag+1));
					break;
				}
				if(accumulate==k){
					kick[flag]=true;
					System.out.println("kick person===="+(flag+1));
					accumulate=0;
					counter++;
				}				
			}
			flag=(flag+1)%n;
		}
		
	}
	public static void main(String[] args) {
		JosephCircle jCircle = new JosephCircle();
		jCircle.josephCircle(20, 3);

		int[] joseph = jCircle.joseph(20,3);
		System.out.print(Arrays.toString(joseph));
	}

	/**
	 * @author Leon
	 * 算法思路：一个数组作为环的标号，数到3的，把数记下，把该数置0代表出列，count 为计数器，到n个都出列了停止。
	 */
	public int[] joseph(int n,int k){
		int[] joseph = new int[n];
		int[] circle = getInitArray(20);
		
		int count = 0;	//出列人数
		int flag = 0;	//指针
		int accumulate = 0;//报数
		while(count<n){
			if(circle[flag]!=0){
				accumulate++;
				if(count==n-1){//表示已经是最后一位，直接出列
					joseph[count] = circle[flag];
					count++;
				}
			
				if(accumulate==k){//报数击中
					joseph[count] = circle[flag];
					circle[flag]=0;
					accumulate=0;
					count++;
				}
			}
			flag=(flag+1)%n;//对付环状的关键一步
		}
		
		return joseph;
	}
	public int[] getInitArray(int n){
		int[] array = new int[n];
		for(int i=0;i<n;i++){
			array[i]=i+1;
		}
		return array;
	}
}