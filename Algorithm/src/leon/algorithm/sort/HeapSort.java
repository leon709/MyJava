package leon.algorithm.sort;

public class HeapSort {
	public int size;
	public int queue[];

	public HeapSort(int[] list) {
		queue = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			add(list[i]);
		}
		System.out.println(size);
		int i=0;
		while(size>0){
			list[i++]=remove();
		}	

	}

	public void add(int e) {
		int i = size;
		while (i > 0) {
			int parent = (i - 1) / 2;
			int root = queue[parent];
			if (e <= root)
				break;
			queue[i] = root;
			i = parent;
		}
		queue[i] = e;
		size++;
	}

	public int remove() {
		int parent = 0;
		if (size == 0) {
			throw new NullPointerException("queue is null");
		}
		int max = queue[0];// top
		int last = queue[size - 1];// last
		queue[0] = last;// add the last to top
		size--;
		if (size == 2 && last < queue[1]) { // 只剩下最后两个结点，进行比较
			queue[0] = queue[1];
			queue[1] = last;
		}
		if (size > 2) { // 大于三个结点的，向下旋转
			while (parent < size / 2) {
				int left = 2 * parent + 1;// left child
				int right = left + 1;// right child
				int root = queue[parent];// root
				if (root > queue[left] && root > queue[right])
					break;

				if (queue[left] >= queue[right]) {// 左节点大于右节点，左节点和父节点交换
					queue[parent] = queue[left];
					queue[left] = root;
					parent = left;
				} else {
					queue[parent] = queue[right];
					queue[right] = root;
					parent = right;
				}
				if (right * 2 >= size)//没有子节点了，结束循环
					break;

			}

		}
		return max;
	}

	public static void main(String[] args) {
		int[]list=new int[10000];
		for (int i = 0; i <list.length; i++) {
			list[i]=i;
			
		}
		//HeapSort sort = new HeapSort(list);
		for (int i : list) {
			System.out.print(i+" ");
			if(i%10==0)
				System.out.println();
		}
	}

}

