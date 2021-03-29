package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DuplicateNumberWithSqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.repeatedNumber(arr));
		sc.close();
	}

	static class Solution {
		public int repeatedNumber(final List<Integer> A) {
			int n = A.size();
			int sq = (int) Math.sqrt(n);
			int noOfBuckets = (int) Math.ceil((1.0 * n) / sq);
			int[] bucketCnt = new int[noOfBuckets];
			for (int i = 0; i < n; i++) {
				int bucketIdx = (int) Math.ceil((1.0 * A.get(i)) / sq) - 1;
				bucketCnt[bucketIdx]++;
			}
			int finalIdx = noOfBuckets - 1;
			for (int i = 0; i < noOfBuckets; i++) {
				if (bucketCnt[i] > sq) {
					finalIdx = i;
					break;
				}
			}
			Map<Integer, Integer> mapCnt = new HashMap<>();
			for (int i = 0; i < n; i++) {
				if (A.get(i) >= (finalIdx * sq + 1) && A.get(i) <= (finalIdx + 1) * sq) {
					if (mapCnt.containsKey(A.get(i))) {
						return A.get(i);
					}
					mapCnt.put(A.get(i), 1);
				}
			}
			return 0;
		}
	}
}
