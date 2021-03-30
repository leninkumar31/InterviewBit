package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class BalanceArray {

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
			if (n == 0 || n == 2)
				return 0;
			if (n == 1)
				return 1;
			long[] evenArr = new long[n];
			long[] oddArr = new long[n];
			evenArr[0] = A.get(0);
			oddArr[1] = A.get(1);
			for (int i = 2; i < n; i++) {
				if (i % 2 == 0) {
					evenArr[i] += evenArr[i - 2] + A.get(i);
				} else {
					oddArr[i] += oddArr[i - 2] + A.get(i);
				}
			}
			int ans = 0;
			for (int i = 0; i < n; i++) {
				long evenSum = 0l;
				long oddSum = 0l;
				if (i % 2 == 0) {
					evenSum = oddArr[n - n % 2 - 1] - ((i - 1 < 0) ? 0 : oddArr[i - 1])
							+ (i - 2 < 0 ? 0 : evenArr[i - 2]);
					oddSum = evenArr[n - (n % 2 == 0 ? 2 : 1)] - evenArr[i] + (i - 1 < 0 ? 0 : oddArr[i - 1]);
				} else {
					evenSum = oddArr[n - n % 2 - 1] - oddArr[i] + evenArr[i - 1];
					oddSum = evenArr[n - (n % 2 == 0 ? 2 : 1)] - ((i - 1 < 0) ? 0 : evenArr[i - 1])
							+ (i - 2 < 0 ? 0 : oddArr[i - 2]);
				}
				if (evenSum == oddSum) {
					ans++;
				}
			}
			return ans;
		}
	}

}
