package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				arr.add(sc.nextInt());
			}
			matrix.add(arr);
			sc.nextLine();
		}
		Solution sol = new Solution();
		sol.rotate(matrix);
		System.out.println(matrix);
		sc.close();
	}

	static class Solution {
		public void rotate(ArrayList<ArrayList<Integer>> a) {
			int n = a.size();
			int numLayers = n / 2;
			for (int i = 0; i < numLayers; i++) {
				for (int j = i; j < n - i - 1; j++) {
					int temp = a.get(i).get(j);
					a.get(i).set(j, a.get(n - j - 1).get(i));
					a.get(n - j - 1).set(i, a.get(n - i - 1).get(n - j - 1));
					a.get(n - i - 1).set(n - j - 1, a.get(j).get(n - i - 1));
					a.get(j).set(n - i - 1, temp);
				}
			}
		}
	}

}
