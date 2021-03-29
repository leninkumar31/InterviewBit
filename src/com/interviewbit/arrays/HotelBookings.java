package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HotelBookings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			A.add(sc.nextInt());
		}
		ArrayList<Integer> B = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			B.add(sc.nextInt());
		}
		int K = sc.nextInt();
		Solution sol = new Solution();
		System.out.println(sol.hotel(A, B, K));
		sc.close();
	}

	static class Solution {
		public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
			int n = arrive.size();
			if (n == 0) {
				return true;
			}
			int cnt = 0;
			Collections.sort(arrive);
			Collections.sort(depart);
			int i = 0, j = 0;
			while (i < n) {
				if (depart.get(j) > arrive.get(i)) {
					cnt++;
				} else {
					j++;
				}
				i++;
			}
			return cnt <= K;
		}
	}

}
