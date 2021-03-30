package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectPeakOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.perfectPeak(arr));
		sc.close();
	}

	static class Solution {
		public int perfectPeak(ArrayList<Integer> A) {
			int n = A.size();
			if (n == 0) {
				return 0;
			}
			int[] preMinArr = new int[n];
			int[] suffMaxArr = new int[n];
			preMinArr[0] = A.get(0);
			for (int i = 1; i < n; i++) {
				preMinArr[i] = Math.max(A.get(i), preMinArr[i - 1]);
			}
			suffMaxArr[n - 1] = A.get(n - 1);
			for (int i = n - 2; i >= 0; i--) {
				suffMaxArr[i] = Math.min(A.get(i), suffMaxArr[i + 1]);
			}
			for (int i = 1; i < n - 1; i++) {
				if (A.get(i) > preMinArr[i - 1] && A.get(i) < suffMaxArr[i + 1]) {
					System.out.println(A.get(i));
					return 1;
				}
			}
			return 0;
		}
	}

}
