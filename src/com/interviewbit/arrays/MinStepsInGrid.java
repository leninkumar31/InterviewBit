package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MinStepsInGrid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> rowArr = new ArrayList<>();
		ArrayList<Integer> colArr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int rowVal = sc.nextInt();
			rowArr.add(rowVal);
			int colVal = sc.nextInt();
			colArr.add(colVal);
		}
		Solution sol = new Solution();
		System.out.println(sol.coverPoints(rowArr, colArr));
		sc.close();
	}
}

class Solution {
	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		int rowCnt = A.size();
		int ans = 0;
		for (int i = 1; i < rowCnt; i++) {
			ans += Math.max(Math.abs(A.get(i)-A.get(i-1)), Math.abs(B.get(i)-B.get(i-1)));
		}
		return ans;
	}
}
