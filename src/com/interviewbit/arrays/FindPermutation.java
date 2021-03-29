package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class FindPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		sc.nextLine();
		Solution sol = new Solution();
		System.out.println(sol.findPerm(str, n));
		sc.close();
	}

	static class Solution {
		public ArrayList<Integer> findPerm(final String A, int B) {
			ArrayList<Integer> perm = new ArrayList<Integer>();
			int start = 1, end = B;
			for (int i = 0; i < A.length(); i++) {
				if (A.charAt(i) == 'I') {
					perm.add(start++);
				} else {
					perm.add(end--);
				}
			}
			perm.add(start);
			return perm;
		}
	}

}
