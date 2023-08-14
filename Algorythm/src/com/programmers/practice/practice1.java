package com.programmers.practice;

public class practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int start = 3;
		int end = 10;
		int cnt = 0;
		int ind = 0;
		for(int i = start; i <= end; i++) {
			cnt++;
		}
		int answer [] = new int[cnt];
		
		for(int i = start; i <= end; i++) {
			answer[ind] = i;
			ind++;
		}
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
	}

}
