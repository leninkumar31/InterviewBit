package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < m; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				arr.add(sc.nextInt());
			}
			matrix.add(arr);
			sc.nextLine();
		}
		Solution sol = new Solution();
		sol.setZeroes(matrix);
		System.out.println(matrix);
		sc.close();
	}

	static class Solution {
		public void setZeroes(ArrayList<ArrayList<Integer>> a) {
			int m = a.size();
			int n = a.get(0).size();
			int[] row = new int[m];
			int[] col = new int[n];
			for (int i = 0; i < m; i++) {
				row[i] = 1;
			}
			for (int i = 0; i < n; i++) {
				col[i] = 1;
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (a.get(i).get(j) == 0) {
						row[i] = 0;
						col[j] = 0;
					}
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (row[i] == 0 || col[j] == 0) {
						a.get(i).set(j, 0);
					}
				}
			}
		}
	}

}
