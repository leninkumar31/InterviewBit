package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxAbsDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.maxArr(arr));
		sc.close();

	}

	static class Solution {
	    public int maxArr(ArrayList<Integer> A) {
	        int max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE, min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
	        for(int i=0;i<A.size();i++){
	            max1 = Math.max(A.get(i)+i, max1);
	            min1 = Math.min(A.get(i)+i, min1);
	            max2 = Math.max(A.get(i)-i, max2);
	            min2 = Math.min(A.get(i)-i, min2);
	        }
	        return Math.max(max1-min1, max2-min2);
	    }
	}

}
