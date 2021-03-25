package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSumContigousSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.maxSubArray(arr));
		sc.close();
	}
	static class Solution {
		// DO NOT MODIFY THE LIST. IT IS READ ONLY
		public int maxSubArray(final List<Integer> A) {
			int n = A.size();
			int maxVal = A.get(0);
			int tempVal = A.get(0)>=0?A.get(0):0;
			for (int i = 1; i < n; i++) {
				tempVal += A.get(i);
				maxVal = Math.max(tempVal, maxVal);
				if (tempVal<0){
					tempVal = 0;
				}
			}
			return maxVal;
		}
	}
}