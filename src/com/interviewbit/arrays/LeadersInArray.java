package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class LeadersInArray {

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
		public ArrayList<Integer> solve(ArrayList<Integer> A) {
			ArrayList<Integer> leaders = new ArrayList<>();
			if (A.size() == 0) {
				return leaders;
			}
			int maxVal = Integer.MIN_VALUE;
			for (int i = A.size() - 1; i >= 0; i--) {
				if (A.get(i) > maxVal) {
					leaders.add(A.get(i));
				}
				maxVal = Math.max(maxVal, A.get(i));
			}
			return leaders;
		}
	}

}
