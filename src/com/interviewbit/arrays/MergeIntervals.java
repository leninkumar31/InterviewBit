package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Interval> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			arr.add(new Interval(start, end));
		}
		Solution sol = new Solution();
		System.out.println(sol.merge(arr));
		sc.close();
	}

	static class Solution {
		public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
			Collections.sort(intervals, new Comparator<Interval>() {
				@Override
				public int compare(Interval o1, Interval o2) {
					if (o1.start == o2.start) {
						return o1.end - o2.end;
					}
					return o1.start - o2.start;
				}

			});
			ArrayList<Interval> res = new ArrayList<Interval>();
			Interval curr = intervals.get(0);
			for (int i = 1; i < intervals.size(); i++) {
				if (intervals.get(i).start <= curr.end) {
					curr.end = Math.max(curr.end, intervals.get(i).end);
				} else {
					res.add(curr);
					curr = intervals.get(i);
				}
			}
			res.add(curr);
			return res;
		}
	}

}
