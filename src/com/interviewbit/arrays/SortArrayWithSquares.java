package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortArrayWithSquares {

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
			for (int i = 0; i < A.size(); i++) {
				A.set(i, A.get(i) * A.get(i));
			}
			ArrayList<Integer> res = new ArrayList<Integer>();
			int l = 0, r = A.size() - 1;
			while (l <= r) {
				if (A.get(l) > A.get(r)) {
					res.add(A.get(l));
					l++;
				} else {
					res.add(A.get(r));
					r--;
				}
			}
			Collections.reverse(res);
			return res;
		}
	}

}
