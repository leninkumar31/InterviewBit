package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MinLightsToActivate {

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
			int ans = 0;
			for (int i = 0; i < A.size(); i++) {
				boolean isBulbPresent = false;
				for (int j = Math.min(i + B - 1, A.size() - 1); j >= Math.max(i - B + 1, i); j--) {
					if (A.get(j) == 1) {
						ans++;
						i = j + B - 1;
						isBulbPresent = true;
						break;
					}
				}
				if (!isBulbPresent) {
					return -1;
				}
			}
			return ans;
		}
	}

}
