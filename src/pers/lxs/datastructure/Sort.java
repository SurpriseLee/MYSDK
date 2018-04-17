package pers.lxs.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[]{5, 6, 3, 8, 9, 4, 0, 2, 1, 7};
		
		// Ascend sort
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		// Descent sort
		// Note: This is a Integer object array, not a int[]
		Integer[] aa = new Integer[]{5, 6, 3, 8, 9, 4, 0, 2, 1, 7};
		Arrays.sort(aa, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		System.out.println(Arrays.toString(aa));
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			Random random = new Random();
			list.add(random.nextInt(10));
		}
		
		System.out.println(list.toString());
		// Ascend sort
		Collections.sort(list);
		System.out.println(list.toString());

		// Descent sort
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list.toString());
		
		// Reverse
		Collections.reverse(list);
		System.out.println(list.toString());
	}

}
