package leon.algorithm;

public class Joseph {

	public static void main(String[] args) {
		new Thread(new Runnable(){
			public void run(){
				joseph(30,5);
			}
			public void joseph(int n, int k){
				int[] array = new int[n];
				for(int i=0;i<n;i++){
					array[i]=i+1;
				}
				int pointer = 0;
				int accumulate=0;
				int count = 0;
				while(count<n){
					if(array[pointer]!=0){
						accumulate++;
						if(n-count == 1){
							System.out.print(array[pointer]+" ");
							array[pointer]=0;
							count++;
						}
						if(accumulate==k){
							System.out.print(array[pointer]+" ");
							array[pointer]=0;
							accumulate=0;
							count++;
						}
					}
					pointer = (pointer+1)%n;
				}
				System.out.println();
			}
		}).start();
	}
}