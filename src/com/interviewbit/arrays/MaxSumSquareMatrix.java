package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxSumSquareMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				arr.add(sc.nextInt());
			}
			matrix.add(arr);
			sc.nextLine();
		}
		int k = sc.nextInt();
		Solution sol = new Solution();
		System.out.println(sol.solve(matrix, k));
		sc.close();
	}

	static class Solution {
		public int solve(ArrayList<ArrayList<Integer>> A, int B) {
			int n = A.size();
			for (int i = 1; i < n; i++) {
				A.get(0).set(i, A.get(0).get(i) + A.get(0).get(i - 1));
			}
			for (int i = 1; i < n; i++) {
				A.get(i).set(0, A.get(i).get(0) + A.get(i - 1).get(0));
			}
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					A.get(i).set(j,
							A.get(i).get(j) + A.get(i).get(j - 1) + A.get(i - 1).get(j) - A.get(i - 1).get(j - 1));
				}
			}
			int maxSum = Integer.MIN_VALUE;
			for (int i = B - 1; i < n; i++) {
				for (int j = B - 1; j < n; j++) {
					if (i == B - 1 && j == B - 1) {
						maxSum = Math.max(maxSum, A.get(i).get(j));
					} else if (i == B - 1) {
						maxSum = Math.max(maxSum, A.get(i).get(j) - A.get(i).get(j - B));
					} else if (j == B - 1) {
						maxSum = Math.max(maxSum, A.get(i).get(j) - A.get(i - B).get(j));
					} else {
						maxSum = Math.max(maxSum,
								A.get(i).get(j) - A.get(i).get(j - B) - A.get(i - B).get(j) + A.get(i - B).get(j - B));
					}
				}
			}
			return maxSum;
		}
	}

}
