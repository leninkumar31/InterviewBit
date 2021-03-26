package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class DuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.repeatedNumber(arr));
		sc.close();
	}

	static class Solution {
		public int repeatedNumber(final List<Integer> A) {
			int n = A.size();
			BitSet bits = new BitSet(n);
			int ans = -1;
			for (int i = 0; i < n; i++) {
				if (!bits.get(i)) {
					bits.set(i);
					int startVal = i + 1;
					int currInx = i + 1;
					while (true) {
						int nextIdx = A.get(currInx - 1);
						if(bits.get(nextIdx-1)) {
							if(startVal == nextIdx) {
								break;
							}
							return nextIdx;
						}
						bits.set(nextIdx - 1); 
						currInx = nextIdx;
					}
				}
			}
			return ans;
		}
	}
}
