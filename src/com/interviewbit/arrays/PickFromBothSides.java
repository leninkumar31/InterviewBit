package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class PickFromBothSides {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		int k = sc.nextInt();
		Solution sol = new Solution();
		System.out.println(sol.solve(arr, k));
		sc.close();
	}

	static class Solution {
		public int solve(ArrayList<Integer> A, int B) {
			int n = A.size();
			int[] preSum = new int[n];
			preSum[0] = A.get(0);
			for (int i = 1; i < A.size(); i++) {
				preSum[i] += preSum[i - 1] + A.get(i);
			}
			if (n == B) {
				return preSum[n - 1];
			}
			int ans = Math.max(preSum[B - 1], preSum[n - 1] - preSum[n - 1 - B]);
			for (int i = B - 1; i > 0; i--) {
				int j = B - i;
				ans = Math.max(ans, preSum[i - 1] + preSum[n - 1] - preSum[n - 1 - j]);
			}
			return ans;
		}
	}

}
