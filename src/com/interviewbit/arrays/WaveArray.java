package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WaveArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.wave(arr));
		sc.close();
	}

	static class Solution {
		public ArrayList<Integer> wave(ArrayList<Integer> A) {
			int n = A.size();
			Collections.sort(A);
			for (int i = 0; i < n; i += 2) {
				if (i <= n - 2) {
					int temp = A.get(i + 1);
					A.set(i + 1, A.get(i));
					A.set(i, temp);
				}
			}
			return A;
		}
	}

}
