package com.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddOneToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<n;i++) {
			arr.add(sc.nextInt());
		}
		Solution sol = new Solution();
		System.out.println(sol.plusOne(arr));
		sc.close();
	}

	static class Solution {
	    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
			ArrayList<Integer> ans = new ArrayList<>();
			int n = A.size();
			int start = 0;
			while(start<n-1) {
				if (A.get(start)==0) {
					start++;
				}else {
					break;
				}
			}
			int carry = 0;
			for(int i=n-1;i>=start;i--) {
			    int val = A.get(i);
			    if (carry!=0 || i==n-1){
	    			val += 1;
	    			carry = val / 10;
	    			if (carry == 1) {
	    				val = val%10;
	    			}
			    }
			    ans.add(val);
			}
			if(carry!=0){
			    ans.add(carry);
			}
			Collections.reverse(ans);
			return ans;
		}
	}

}
