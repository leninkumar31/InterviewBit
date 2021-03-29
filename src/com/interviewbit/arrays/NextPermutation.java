package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.nextPermutation(arr));
		sc.close();
	}

	static class Solution {
		public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
			boolean isSorted = true;
			for (int i = 1; i < A.size(); i++) {
				if (A.get(i - 1) < A.get(i)) {
					isSorted = false;
					break;
				}
			}
			if (isSorted) {
				reverse(A, 0, A.size() - 1);
				return A;
			}

			int i = A.size() - 2;
			while (i >= 0 && A.get(i + 1) <= A.get(i)) {
				i--;
			}
			int idx = binarySearch(A, i + 1, A.size() - 1, A.get(i));
			swap(A, i, idx);
			reverse(A, i + 1, A.size() - 1);
			return A;
		}

		private int binarySearch(ArrayList<Integer> A, int start, int end, int val) {
			int idx = -1;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				if (A.get(mid) <= val) {
					end = mid - 1;
				} else {
					start = mid + 1;
					if (idx == -1 || A.get(mid) < A.get(idx)) {
						idx = mid;
					}
				}
			}
			return idx;
		}

		private void swap(ArrayList<Integer> A, int start, int end) {
			int temp = A.get(start);
			A.set(start, A.get(end));
			A.set(end, temp);
		}

		private void reverse(ArrayList<Integer> A, int start, int end) {
			while (start < end) {
				int temp = A.get(start);
				A.set(start, A.get(end));
				A.set(end, temp);
				start++;
				end--;
			}
		}
	}

}
