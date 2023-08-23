package com.programmers.practice;

import java.util.Arrays;
import java.util.Collection;

public class practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1,0,1};
		int[] b = {1,0,-1};
		int[] c = new int[a.length];
		int answer = 0;
		for(int i = 0; i < a.length; i++) {
			answer += c[i] = a[i] * b[i];
		}
		System.out.println("\n answer = " + answer);
	}
}
	