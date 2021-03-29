package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class KthRowOfPascal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Solution sol = new Solution();
		System.out.println(sol.getRow(n));
		sc.close();
	}

	static class Solution {
		public ArrayList<Integer> getRow(int A) {
			ArrayList<Integer> prevRow = new ArrayList<>();
			prevRow.add(1);
			if (A == 0) {
				return prevRow;
			}
			prevRow.add(1);
			for (int i = 2; i <= A; i++) {
				ArrayList<Integer> currRow = new ArrayList<>();
				currRow.add(prevRow.get(0));
				for (int j = 1; j < prevRow.size(); j++) {
					currRow.add(prevRow.get(j) + prevRow.get(j - 1));
				}
				currRow.add(prevRow.get(prevRow.size() - 1));
				prevRow = currRow;
			}
			return prevRow;
		}
	}

}
