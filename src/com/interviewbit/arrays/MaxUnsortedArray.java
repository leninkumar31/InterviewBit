package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxUnsortedArray {

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

			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < A.size(); i++) {
				list.add(A.get(i));
			}
			Collections.sort(A);
			int min = -1, max = -1;
			for (int i = 0; i < A.size(); i++) {
				if (A.get(i) != list.get(i)) {
					min = i;
					break;
				}
			}
			for (int i = A.size() - 1; i >= 0; i--) {
				if (A.get(i) != list.get(i)) {
					max = i;
					break;
				}
			}
			ArrayList<Integer> res = new ArrayList<>();
			if (min == -1 || max == -1) {
				res.add(-1);
			} else {
				res.add(min);
				res.add(max);
			}
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
