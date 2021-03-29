package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatAndMissing {

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
		public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
			ArrayList<Integer> res = new ArrayList<Integer>();
			int n = A.size();
			long formSum = 1l * n * (n + 1) / 2;
			long formSq = 1l * n * (n + 1) * (2 * n + 1) / 6;
			long sumOfNum = 0l;
			long sumOfSq = 0l;
			for (int i = 0; i < A.size(); i++) {
				sumOfNum += A.get(i);
				sumOfSq += 1l * A.get(i) * A.get(i);
			}
			long sqDiff = formSq - sumOfSq;
			long sumDiff = formSum - sumOfNum;
			long yPlusx = sqDiff / sumDiff;
			long yMinusx = sumDiff;
			int x = (int) (yPlusx - yMinusx) / 2;
			int y = (int) (yPlusx + yMinusx) / 2;
			res.add(x);
			res.add(y);
			return res;
		}
	}

}
