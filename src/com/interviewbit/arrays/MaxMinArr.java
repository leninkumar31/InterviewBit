package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxMinArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.solve(arr));
		sc.close();
	}

	static class Solution {
		public int solve(ArrayList<Integer> A) {
			int minVal = Integer.MAX_VALUE;
			int maxVal = Integer.MIN_VALUE;
			for (int i = 0; i < A.size(); i++) {
				minVal = Math.min(minVal, A.get(i));
				maxVal = Math.max(maxVal, A.get(i));
			}
			return maxVal + minVal;
		}
	}

}
