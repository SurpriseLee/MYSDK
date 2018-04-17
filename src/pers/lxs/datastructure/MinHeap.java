package pers.lxs.datastructure;


public class MinHeap {

	public static void main(String[] args) {

		int[] a = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		
		MinHeap heap = new MinHeap(a);
		heap.buildHeap();
		System.out.println(heap.toString());
		
		heap.insert(10);
		heap.removeFirst();
		
		System.out.println("Heap Sort: ");
		
		while(!heap.isEmpty()) {
			System.out.print(heap.removeFirst() + " ");
		}
		
		System.out.println();
		
	}
	
	private final static int DEFAULE_LENGTH = 16;
	private final static double LOAD_FACTOR = 0.75;
	private int[] array;

	private int size;
	
	public MinHeap() {
		this(DEFAULE_LENGTH);
	}
	
	public MinHeap(int size) {
		this.array = new int[size];
		this.size = 0;
	}
	
	public MinHeap(int[] array) {
		int len = array.length > DEFAULE_LENGTH * LOAD_FACTOR ? (array.length / DEFAULE_LENGTH + 1) * DEFAULE_LENGTH : DEFAULE_LENGTH;
		this.array = new int[len];
		System.arraycopy(array, 0, this.array, 0, array.length);
		this.size = array.length;
	}
	
	public void buildHeap() {
		adjustHeap();
	}

	public void adjustHeap() {
		
		for (int i = (size - 2) / 2; i >= 0; i--) {
			siftDown(i);
		}
		
	}
	
	public void insert(int e) {
		size += 1;
		array[size - 1] = e;
		adjustHeap();
	}
	
	public int removeFirst() {
		
		if(size <= 0) {
			return Integer.MAX_VALUE;
		}
		
		int result = array[0];
		
		array[0] = array[size - 1];
		size -= 1;
		
		adjustHeap();
		
		return result;
	}

	private void siftDown(int pos) {
		
		if(isLeaf(pos)) {
			return;
		}
		
		int leftChild = 2 * pos + 1;
		int rightChild = 2 * pos + 2;
		
		int index = (rightChild < size && array[rightChild] < array[leftChild]) ? rightChild : leftChild;
		
		if(array[pos] > array[index]) {
			int temp = array[index];
			array[index] = array[pos];
			array[pos] = temp;
			siftDown(index);
		}
		
		return;
	}

	private boolean isLeaf(int pos) {
		if(2 * pos + 1 > size - 1) {
			return true;
		}
		
		return false;
	}
	
	public boolean isEmpty() {
		if(size > 0) {
			return false;
		}
		
		return true;
	}
	
	public String toString() {
		
		if(size <= 0) {
			return "[]";
		}

		StringBuilder sb = new StringBuilder("[");
		
		for(int i = 0; i < size; i++) {
			sb.append(array[i] + ", ");
		}
		String string = sb.toString();
		string = string.substring(0, string.length() - 2) + "]";
		return string;
 	}
}
