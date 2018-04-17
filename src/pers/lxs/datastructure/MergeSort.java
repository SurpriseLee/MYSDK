package pers.lxs.datastructure;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		
		int[] array = new int[]{2,5,6,8,7,3,1,9};
//		int[] array = new int[]{1,2,3,4,5,6,7,0};
		
		mergeSort(array);
		
		System.out.println(Arrays.toString(array));
		
		System.out.println(n);
	}
	
	static int n = 0;
	
	public static void mergeSort(int[] array) {
		
		if(array == null || array.length <= 0) {
			return;
		}
		
		mergeSort(array, 0, array.length - 1);
	}
	
	private static void mergeSort(int[] array, int start, int end) {
		
		if(end <= start) {
			return;
		}
		
		int mid = (start + end) >> 1;
		
		mergeSort(array, start, mid);
		mergeSort(array, mid + 1, end);
		
		merge(array, start, mid, end);
	}
	
	private static void merge(int[] array, int start, int mid, int end) {
		
		if(end <= start) {
			return;
		}
		
		int[] temp = new int[end - start + 1];
		
		int index = temp.length - 1;
		int p = mid;    int q = end;
		
		while(p >= start && q > mid) {
			
			if(array[p] >= array[q]) {
				temp[index] = array[p--];
				n += (q - mid);
			} else {
				temp[index] = array[q--];
			}
			
			index--;
		}
		
		while(p >= start) {
			temp[index--] = array[p--];
		}
		
		while(q > mid) {
			temp[index--] = array[q--];
		}
		
		index = 0;
		
		while(index < temp.length) {
			array[start + index] = temp[index];
			index++;
		}
	}

}
