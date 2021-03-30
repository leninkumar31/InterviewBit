package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class MaxSumTriplet {

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
			int n = A.size();
			int[] maxArr = new int[n];
			maxArr[n - 1] = Integer.MIN_VALUE;
			for (int i = n - 2; i >= 0; i--) {
				maxArr[i] = Math.max(A.get(i + 1), maxArr[i + 1]);
			}
			int ans = 0;
			Stack<Integer> st = new Stack<>();
			for (int i = 0; i < n - 1; i++) {
				if (!st.isEmpty()) {
					while (!st.isEmpty() && st.peek() > maxArr[i]) {
						st.pop();
					}
					while (!st.isEmpty() && st.peek() < A.get(i) && A.get(i) < maxArr[i]) {
						ans = Math.max(ans, st.peek() + A.get(i) + maxArr[i]);
						st.pop();
					}
				}
				st.add(A.get(i));
			}
			return ans;
		}
	}

}
