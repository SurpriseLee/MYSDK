package pers.lxs.test;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		
		int[] a = new int[] { 1, 5, 6, 9, 2, 8, 7, 3, 4, 11, 0, 78, 95, 46, 58, 63, 100};
		
		System.out.println(Arrays.toString(heapSort(a)));
	}
	
	public static int[] heapSort(int[] a) {
		int[] sorted = new int[a.length];
		
		MinHeap minHeap = new MinHeap(a);
		
		int index = 0;
		while(!minHeap.isEmpty()) {
			sorted[index++] = minHeap.removeFirst();
		}
		
		return sorted;
	}
	
	static class MinHeap {
		
		private int[] a;
		private int size;
		
		public MinHeap(int[] a) {
			this.a = a;
			this.size = a.length;
			buildHeap();
		}
		
		public int removeFirst() {
			int min = a[0];
			
			a[0] = a[size - 1];
			size -= 1;
			
			siftDown(0);
			
			return min;
		}
		
		public boolean insert(int e) {
			
			if(size >= a.length) {
				return false;
			}
			
			size += 1;
			a[size - 1] = e;
			
			int pos = size - 1;
			int parent = (pos - 1) / 2;
			
			while(a[parent] > a[pos]) {
				swap(parent, pos);
				pos = parent;
			}
			
			return true;
		}
		
		public boolean isEmpty() {
			
			if(size > 0) {
				return false;
			}
			
			return true;
		}
		
		private void buildHeap() {
			
			for(int i = (size - 2) / 2; i >= 0; i--) {
				siftDown(i);
			}
		}
		
		private void siftDown(int pos) {
			
			while(!isLeaf(pos)) {
				
				int leftChild = 2 * pos + 1;
				int rightChild = 2 * pos + 2;
				
				int index = (rightChild < size && a[rightChild] < a[leftChild]) ? rightChild : leftChild;
				
				if(a[pos] <= a[index]) {
					return;
				}
				
				swap(pos, index);
				
				pos = index;
			}
		}
		
		private void swap(int pos1, int pos2) {
			
			int temp = a[pos1]; 
			a[pos1] = a[pos2];
			a[pos2] = temp;
			
		}
		
		private boolean isLeaf(int pos) {
			
			if(2 * pos + 1 > size - 1) {
				return true;
			}
		
			return false;
		}
		
	}

}
