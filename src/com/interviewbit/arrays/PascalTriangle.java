package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Solution sol = new Solution();
		System.out.println(sol.solve(n));
		sc.close();
	}

	static class Solution {
		public ArrayList<ArrayList<Integer>> solve(int A) {
			ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> first = new ArrayList<Integer>();
			first.add(1);
			pascal.add(first);
			for (int i = 1; i < A; i++) {
				ArrayList<Integer> newRow = new ArrayList<Integer>();
				newRow.add(1);
				for (int j = 1; j < pascal.get(pascal.size() - 1).size(); j++) {
					newRow.add(pascal.get(pascal.size() - 1).get(j) + pascal.get(pascal.size() - 1).get(j - 1));
				}
				newRow.add(1);
				pascal.add(newRow);
			}
			return pascal;
		}
	}

}
