package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.largestNumber(arr));
		sc.close();
	}

	static class Solution {
		public String largestNumber(final List<Integer> A) {
			int cnt = 0;
			for (int i = 0; i < A.size(); i++) {
				if (A.get(i) == 0) {
					cnt++;
				}
			}
			if (cnt == A.size()) {
				return "0";
			}
			Collections.sort(A, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					String sA = o1.toString();
					String sB = o2.toString();
					return (sB + sA).compareTo(sA + sB);
				}
			});
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < A.size(); i++) {
				sb.append(A.get(i).toString());
			}
			return sb.toString();
		}
	}

}
