package pers.lxs.test;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] a = new int[] { 1, 5, 6, 9, 2, 8, 7, 3, 4 };

		quickSort(a);

		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	public static void quickSort(int[] a, int start, int end) {

		if (end <= start) {
			return;
		}

		int pivot = a[start];
		int p = start + 1;
		int q = end;

		while (p < q) {
			while (q > p && a[q] >= pivot) {
				q--;
			}

			while (p < q && a[p] < pivot) {
				p++;
			}

			if (p != q) {
				int temp = a[p];
				a[p] = a[q];
				a[q] = temp;
			}
		}

		if (a[p] > pivot) {
			p -= 1;
		}

		a[start] = a[p];
		a[p] = pivot;

		quickSort(a, start, p - 1);
		quickSort(a, p + 1, end);

	}

}
