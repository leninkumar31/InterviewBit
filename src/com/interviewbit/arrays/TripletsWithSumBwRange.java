package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TripletsWithSumBwRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.next());
		}
		Solution sol = new Solution();
		System.out.println(sol.solve(arr));
		sc.close();
	}

	static class Solution {
		public int solve(ArrayList<String> A) {
			if (A.size() < 3) {
				return 0;
			}
			ArrayList<Float> triplet = new ArrayList<>();
			for (int i = 0; i < A.size(); i++) {
				float val = Float.parseFloat(A.get(i));
				if (i < 2) {
					triplet.add(val);
					continue;
				}
				if (i == 2) {
					triplet.add(val);
				}
				Collections.sort(triplet);
				if (i > 2) {
					float sum = triplet.get(0) + triplet.get(1) + triplet.get(2);
					if (sum < 1.0) {
						if (val > triplet.get(0)) {
							triplet.set(0, val);
						}
					}
					if (sum > 2.0) {
						if (val < triplet.get(2)) {
							triplet.set(2, val);
						}
					}
				}
				float sum = triplet.get(0) + triplet.get(1) + triplet.get(2);
				if (sum > 1.0 && sum < 2.0) {
					return 1;
				}
			}
			return 0;
		}
	}
}
