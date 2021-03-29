package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class FirstMissingInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.firstMissingPositive(arr));
		sc.close();
	}

	static class Solution {
		public int firstMissingPositive(ArrayList<Integer> A) {
			int n = A.size();
			for (int i = 0; i < n; i++) {
				if (A.get(i) <= 0 || A.get(i) > n) {
					A.set(i, n + 1);
				}
			}
			for (int i = 0; i < n; i++) {
				if (Math.abs(A.get(i)) == n + 1) {
					continue;
				}
				int val = Math.abs(A.get(i));
				if (A.get(val - 1) > 0) {
					A.set(val - 1, -1 * A.get(val - 1));
				}
			}
			int ans = n + 1;
			for (int i = 0; i < n; i++) {
				if (A.get(i) > 0) {
					ans = i + 1;
					break;
				}
			}
			return ans;
		}
	}

}
