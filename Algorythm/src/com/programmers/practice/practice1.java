package com.programmers.practice;

import java.util.Collection;

public class practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int i = 1;
		long answer = -1;
		while((i*i) != n) {
			i++;
			if((i*i) == n) {
				long d = i+1;
				answer = d*d;
				break;
			} else if((i*i) > n) {	
				i = 0;
				answer = -1;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
