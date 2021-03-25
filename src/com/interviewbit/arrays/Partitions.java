package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Partitions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.solve(n, arr));
		sc.close();
	}

	static class Solution {
	    public int solve(int A, ArrayList<Integer> B) {
			if (A < 3) {
				return 0;
			}
			long sum = 0l;
			long[] preSumArr = new long[A];
			for (int i = 0; i < A; i++) {
				sum += B.get(i);
				preSumArr[i] = sum;
			}
			if (sum % 3 != 0) {
				return 0;
			}
			long val = sum / 3;
			int[] firstArr = new int[A];
			int[] secondArr = new int[A];
			for (int i = 0; i < A; i++) {
				if (preSumArr[i] == val) {
					firstArr[i] = 1;
				}
				if (preSumArr[i] == 2 * val) {
					secondArr[i] = 1;
				}
			}
			for (int i = 1; i < A; i++) {
				firstArr[i] += firstArr[i - 1];
			}
			int ans = 0;
			for (int i = 1; i < A - 1; i++) {
				if (secondArr[i] != 0) {
					ans += firstArr[i - 1];
				}
			}
			return ans;
		}
	}


}
