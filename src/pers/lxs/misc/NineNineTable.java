package pers.lxs.misc;

import org.junit.Test;

public class NineNineTable {

	@Test
	public void test() {
		
		int N = 9;
		print(N, N);
		
	}
	
	public void print(int M, int N) {
		
		if(M <= 0 || N <= 0) {
			return;
		}
		
		if(M > 1) {
			print(M - 1, N);
		} else if(M == 1) {
			print(N - 1, N - 1);
			if(N > 1) {
				System.out.println();
			}
			
		}
		System.out.print(M + " * " + N + " = " + (M * N) + "    ");
		
	}
	
}
