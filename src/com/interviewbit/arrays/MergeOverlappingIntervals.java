package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeOverlappingIntervals {

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
		int start = sc.nextInt();
		int end = sc.nextInt();
		Interval newInterval = new Interval(start, end);
		Solution sol = new Solution();
		System.out.println(sol.insert(arr, newInterval));
		sc.close();
	}

	static class Solution {
		public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
			ArrayList<Interval> res = new ArrayList<Interval>();
			int i = 0;
			while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
				res.add(intervals.get(i));
				i++;
			}
			while (i < intervals.size()) {
				if (intervals.get(i).start > newInterval.end || intervals.get(i).end < newInterval.start) {
					break;
				}
				if (intervals.get(i).end >= newInterval.start || intervals.get(i).start <= newInterval.end) {
					newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
					newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
				}
				i++;
			}
			res.add(newInterval);
			while (i < intervals.size()) {
				res.add(intervals.get(i));
				i++;
			}
			return res;
		}
	}

}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "(" + this.start + "," + this.end + ")";
	}
}
