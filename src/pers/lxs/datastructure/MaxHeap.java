package pers.lxs.datastructure;

import java.util.Arrays;

public class MaxHeap {

	public static void main(String[] args) {
		
		int[] a = new int[] {8, 3, 5, 6, 2, 7, 4, 1, 0, 9};
		
		System.out.println(Arrays.toString(a));
		
		MaxHeap maxHeap = new MaxHeap(a);
		
		maxHeap.buildHeap();
		
		System.out.println(maxHeap.toString());
		
		maxHeap.insert(10);
		System.out.println(maxHeap.toString());
		
		System.out.println("Heap Sort: ");
		while(!maxHeap.isEmpty()) {
			System.out.print(maxHeap.removeFirst() + " ");
		}
		System.out.println();
		
		System.out.println(maxHeap.toString());
	}
	
	private final static int DEFAULT_LENGTH = 16;
	private final static double LOAD_FACTOR = 0.75;
	
	private int[] array;
	private int size;
	
	public MaxHeap() {
		this(DEFAULT_LENGTH);
	}
	
	public MaxHeap(int size) {
		this.array = new int[size];
		this.size = 0;
	}
	
	public MaxHeap(int[] array) {
		int len = array.length > DEFAULT_LENGTH * LOAD_FACTOR ? (array.length / DEFAULT_LENGTH + 1) * DEFAULT_LENGTH : DEFAULT_LENGTH;
		this.array = new int[len];
		this.size = array.length;
		System.arraycopy(array, 0, this.array, 0, array.length);
		buildHeap();
		
	}
	
	public void buildHeap() {
		adjustHeap();
	}
	
	public void insert(int e) {
		
		size += 1;
		array[size - 1] = e;
		
		adjustHeap();
	}
	
	public int removeFirst() {
		int max = array[0];
		
		array[0] = array[size - 1];
		size -= 1;
		
		adjustHeap();
		
		return max;
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
		string = string.substring(0, string.length() - 2);
		string = string + "]";
		return string;
	}
	
	private void siftDown(int pos) {
		
		if(isLeaf(pos)) {
			return;
		}
		
		int leftChild = 2 * pos + 1;
		int rightChild = 2 * pos + 2;
		
		int index = (rightChild < size) && array[rightChild] > array[leftChild] ? rightChild : leftChild;
		
		if(array[pos] < array[index]) {
			swap(pos, index);
			siftDown(index);
		}
		
	}
	
	private void swap(int pos1, int pos2) {
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
		
	}
	
	private boolean isLeaf(int pos) {
		
		if(pos * 2  + 1 > size - 1) {
			return true;
		}
		
		return false;
	}

	private void adjustHeap() {
		
		for(int i = (size - 2) / 2; i >= 0; i--) {
			siftDown(i);
		}
	}
	
}
