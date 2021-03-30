package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NBy3RepeatedNumber {

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
			int val1 = Integer.MAX_VALUE;
			int val2 = Integer.MAX_VALUE;
			int count1 = 0, count2 = 0;
			for (int i = 0; i < A.size(); i++) {
				if (val1 == A.get(i)) {
					count1++;
				} else if (val2 == A.get(i)) {
					count2++;
				} else if (count1 == 0) {
					count1++;
					val1 = A.get(i);
				} else if (count2 == 0) {
					count2++;
					val2 = A.get(i);
				} else {
					count1--;
					count2--;
				}
			}
			count1 = count2 = 0;
			for (int i = 0; i < A.size(); i++) {
				if (val1 == A.get(i)) {
					count1++;
				}
				if (val2 == A.get(i)) {
					count2++;
				}
			}
			if (count1 > A.size() / 3) {
				return val1;
			}
			if (count2 > A.size() / 3) {
				return val2;
			}
			return -1;
		}
	}

}
