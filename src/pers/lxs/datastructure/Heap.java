package pers.lxs.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {

	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] x = new int[]{5, 6, 9, 8, 3};
		
		PriorityQueue<Integer> minHeap = getMinHeap();
		for(int i = 0; i < x.length; i++) {
			minHeap.add(x[i]);
		}
		
		while(!minHeap.isEmpty()) {
			System.out.println(minHeap.poll());
		}
		
		PriorityQueue<Integer> maxHeap = getMaxHeap();
		for(int i = 0; i < x.length; i++) {
			minHeap.add(x[i]);
		}
		
		while(!minHeap.isEmpty()) {
			System.out.println(maxHeap.poll());
		}
		
	}
	
	public static PriorityQueue<Integer> getMinHeap() {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(DEFAULT_INITIAL_CAPACITY);
		return minHeap;
	}

	public static PriorityQueue<Integer> getMaxHeap() {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(DEFAULT_INITIAL_CAPACITY, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		
		return maxHeap;
	}
}
