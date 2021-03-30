package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxAreaOfTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<String> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.next());
		}
		Solution sol = new Solution();
		System.out.println(sol.solve(arr));
		sc.close();
	}

	static class Solution {
		public int solve(ArrayList<String> A) {
			int r = A.size();
			int c = A.get(0).length();
			int[] left = new int[3];
			int[] right = new int[3];
			for (int i = 0; i < 3; i++) {
				left[i] = Integer.MAX_VALUE;
				right[i] = Integer.MIN_VALUE;
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					char ch = A.get(i).charAt(j);
					int color = mapColor(ch);
					left[color] = Math.min(left[color], j);
					right[color] = Math.max(right[color], j);
				}
			}
			int[][] top = new int[3][c];
			int[][] bottom = new int[3][c];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < c; j++) {
					top[i][j] = Integer.MAX_VALUE;
					bottom[i][j] = Integer.MIN_VALUE;
				}
			}
			for (int i = 0; i < c; i++) {
				for (int j = 0; j < r; j++) {
					char ch = A.get(j).charAt(i);
					int color = mapColor(ch);
					top[color][i] = Math.min(top[color][i], j);
					bottom[color][i] = Math.max(bottom[color][i], j);
				}
			}
			int area = 0;
			for (int i = 0; i < c; i++) {
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						int z = 3 - x - y;
						if (x != y && bottom[y][i] != Integer.MIN_VALUE && top[x][i] != Integer.MAX_VALUE
								&& left[z] != Integer.MAX_VALUE) {
							area = Math.max(area, (int) Math.ceil(0.5 * (bottom[y][i] - top[x][i] + 1) * (i - left[z] + 1)));
						}
						if (x != y && bottom[y][i] != Integer.MIN_VALUE && top[x][i] != Integer.MAX_VALUE
								&& right[z] != Integer.MIN_VALUE) {
							area = Math.max(area, (int) Math.ceil(0.5 * (bottom[y][i] - top[x][i] + 1) * (right[z] - i + 1)));
						}
					}
				}
			}
			return area;
		}

		private int mapColor(char col) {
			switch (col) {
			case 'r':
				return 0;
			case 'g':
				return 1;
			case 'b':
				return 2;
			}
			return -1;
		}
	}

}
