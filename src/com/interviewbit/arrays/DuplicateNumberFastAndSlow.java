package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuplicateNumberFastAndSlow {

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
			int slow = A.get(0);
			int fast = A.get(0);
			while (true) {
				slow = A.get(slow);
				fast = A.get(A.get(fast));
				if (slow == fast) {
					break;
				}
			}
			slow = A.get(0);
			while (slow != fast) {
				slow = A.get(slow);
				fast = A.get(fast);
			}
			return slow;
		}
	}
}
