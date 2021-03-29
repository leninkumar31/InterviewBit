package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			A.add(sc.nextInt());
		}
		ArrayList<Integer> B = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			B.add(sc.nextInt());
		}
		int K = sc.nextInt();
		Solution sol = new Solution();
		System.out.println(sol.hotel(A, B, K));
		sc.close();
	}

	static class Solution {
		public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
			int n = arrive.size();
			if (n == 0) {
				return true;
			}
			List<Pair> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(new Pair(arrive.get(i), 0));
				list.add(new Pair(depart.get(i), 1));
			}
			Collections.sort(list);
			int maxCnt = 0;
			int cnt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).y == 0) {
					cnt++;
					maxCnt = Math.max(maxCnt, cnt);
				} else {
					cnt--;
				}
			}
			return maxCnt <= K;
		}
	}

}

class Pair implements Comparable<Pair> {
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair o) {
		if (this.x == o.x) {
			return o.y - this.y;
		}
		return this.x - o.x;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
