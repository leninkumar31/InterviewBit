package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxConsecutiveGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.maximumGap(arr));
		sc.close();
	}

	static class Solution {
		public int maximumGap(final List<Integer> A) {
			int n = A.size();
			int minVal = Integer.MAX_VALUE;
			int maxVal = Integer.MIN_VALUE;
			for (int i = 0; i < A.size(); i++) {
				minVal = Math.min(minVal, A.get(i));
				maxVal = Math.max(maxVal, A.get(i));
			}
			float bucketSize = ((float)(maxVal - minVal) / (float)(n - 1));
			int[] maxArr = new int[n - 1];
			int[] minArr = new int[n - 1];
			for (int i = 0; i < n - 1; i++) {
				maxArr[i] = Integer.MIN_VALUE;
				minArr[i] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < n; i++) {
				if (A.get(i) == maxVal || A.get(i) == minVal) {
					continue;
				}
				int bucketIdx = (int) Math.floor((A.get(i) - minVal) / bucketSize);
				maxArr[bucketIdx] = Math.max(maxArr[bucketIdx], A.get(i));
				minArr[bucketIdx] = Math.min(minArr[bucketIdx], A.get(i));
			}
			int prev = minVal;
			int maxGap = 0;
			for (int i = 0; i < n - 1; i++) {
				if (minArr[i] == Integer.MAX_VALUE) {
					continue;
				}
				maxGap = Math.max(maxGap, minArr[i] - prev);
				prev = maxArr[i];
			}
			return Math.max(maxVal - prev, maxGap);
		}
	}
}
