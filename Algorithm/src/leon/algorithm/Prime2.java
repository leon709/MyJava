package leon.algorithm;

public class Prime2 {

	public static void main(String[] args) {
		int n = 40;
		int[] array = getInitArray(n);
		
		for (int i = 2; i < n; i++) {
			if (array[i] != 0) {
				int j, temp;
				temp = array[i];
				for (j = 2 * temp; j < n; j = j + temp) {
					array[j] = 0;
				}
			}
		}
		
		for(int a : array){
			if(a!=0)
				System.out.println(a);
		}
	}
	
	public static int[] getInitArray(int n){
		int[] array = new int[n];
		for (int i = 2; i < array.length; i++) {
			array[i] = i;
		}
		return array;
	}
}