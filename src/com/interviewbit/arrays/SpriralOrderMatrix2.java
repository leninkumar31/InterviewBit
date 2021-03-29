package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class SpriralOrderMatrix2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Solution sol = new Solution();
		System.out.println(sol.generateMatrix(n));
		sc.close();
	}

	static class Solution {
		public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
			int[][] matrix = new int[A][A];
			int val = 1;
			int numLayers = (A + 1) / 2;
			for (int i = 0; i < numLayers; i++) {
				for (int j = i; j < A - i; j++) {
					matrix[i][j] = val;
					val++;
				}
				for (int j = i + 1; j <= A - i - 1; j++) {
					matrix[j][A - i - 1] = val;
					val++;
				}
				for (int j = A - i - 2; j >= i; j--) {
					matrix[A - i - 1][j] = val;
					val++;
				}
				for (int j = A - i - 2; j > i; j--) {
					matrix[j][i] = val;
					val++;
				}
			}
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < A; i++) {
				ArrayList<Integer> row = new ArrayList<Integer>();
				for (int j = 0; j < A; j++) {
					row.add(matrix[i][j]);
				}
				res.add(row);
			}
			return res;
		}
	}

}
