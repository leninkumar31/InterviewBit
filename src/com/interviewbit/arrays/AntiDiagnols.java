package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class AntiDiagnols {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> arr = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				arr.add(sc.nextInt());
			}
			sc.nextLine();
			matrix.add(arr);
		}
		Solution sol = new Solution();
		System.out.println(sol.diagonal(matrix));
		sc.close();
	}

	static class Solution {
		public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			int n = A.size();
			for (int i = 0; i < 2 * n - 1; i++) {
				ArrayList<Integer> arr = new ArrayList<>();
				res.add(arr);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int row = i + j;
					res.get(row).add(A.get(i).get(j));
				}
			}
			return res;
		}
	}

}
