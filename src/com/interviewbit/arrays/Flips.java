package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Flips {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Solution sol = new Solution();
		System.out.println(sol.flip(str));
		sc.close();
	}

	static class Solution {
		public ArrayList<Integer> flip(String A) {
			ArrayList<Integer> ans = new ArrayList<>();
			if (A.length() == 0) {
				return ans;
			}
			int cnt = 0;
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) == '1') {
					cnt++;
				}
			}
			if (cnt == A.length()) {
				return ans;
			}
			int maxVal = cnt;
			int minL = -1, minR = -1;
			int tempVal = 0;
			int tempL = 0;
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) == '1') {
					tempVal -= 1;
				} else {
					tempVal += 1;
				}
				if (tempVal + cnt > maxVal) {
					maxVal = tempVal + cnt;
					minL = tempL;
					minR = i;
				}
				if (tempVal < 0) {
					tempL = i + 1;
					tempVal = 0;
				}
			}
			if (minL != -1 && minR != -1) {
				ans.add(minL + 1);
				ans.add(minR + 1);
			}
			return ans;
		}
	}

}
