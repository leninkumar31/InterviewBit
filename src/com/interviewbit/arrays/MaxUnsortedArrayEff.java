package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxUnsortedArrayEff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			A.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.subUnsort(A));
		sc.close();
	}

	static class Solution {
		public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
			ArrayList<Integer> res = new ArrayList<>();
			int n = A.size();
			int i = 0;
			int j = n - 1;
			while (i < n - 1 && A.get(i) <= A.get(i + 1)) {
				i++;
			}
			if (i == n - 1) {
				res.add(-1);
				return res;
			}
			while (j > 0 && A.get(j) >= A.get(j - 1)) {
				j--;
			}
			int minVal = Integer.MAX_VALUE;
			int maxVal = Integer.MIN_VALUE;
			for (int k = i; k <= j; k++) {
				minVal = Math.min(minVal, A.get(i));
				maxVal = Math.max(maxVal, A.get(i));
				i++;
			}
			int l = 0, r = n - 1;
			while (l <= i && A.get(l) <= minVal) {
				l++;
			}
			while (r >= j && A.get(r) >= maxVal) {
				r--;
			}
			res.add(l);
			res.add(r);
			return res;
		}
	}

	static class Pair implements Comparable<Pair> {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}

		@Override
		public String toString() {
			return "(" + this.x + ", " + this.y + ")";
		}
	}
}
