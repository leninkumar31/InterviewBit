package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NobleInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.solve(arr));
		sc.close();
	}

	static class Solution {
		public int solve(ArrayList<Integer> A) {
			int n = A.size();
			Collections.sort(A);
			System.out.println(A);
			for (int i = 0; i < n; i++) {
				while(i<n-1 && A.get(i)==A.get(i+1)) {
					i++;
				}
				if (A.get(i) == n - i - 1) {
					System.out.println(A.get(i) + " " + (n - i - 1));
					return 1;
				}
			}
			return -1;
		}
	}

}
