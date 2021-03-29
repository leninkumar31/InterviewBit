package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			A.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.maximumGap(A));
		sc.close();
	}

	static class Solution {
		public int maximumGap(final List<Integer> A) {
			List<Pair> list = new ArrayList<>();
			for (int i = 0; i < A.size(); i++) {
				list.add(new Pair(A.get(i), i));
			}
			Collections.sort(list);
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int maxVal = 0;
			for (int i = 0; i < list.size(); i++) {
				if (!pq.isEmpty()) {
					int minVal = pq.peek();
					maxVal = Math.max(maxVal, list.get(i).y - minVal);
				}
				pq.add(list.get(i).y);
			}
			return maxVal;
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
