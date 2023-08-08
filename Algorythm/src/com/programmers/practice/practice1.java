package com.programmers.practice;

public class practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = {1, 2, 3, 100, 99, 98};
		int answer [] = new int[array.length];
		int cnt = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > 0 && array[i] < 50) {
				if(array[i] % 2 == 0) {
					answer[cnt] = array[i];
				} else {
					answer[cnt] = array[i] * 2;
				}
			} else if(array[i] >= 50) {
				if(array[i] % 2 ==0) {
					answer[cnt] = array[i]/2;
				} else {
					answer[cnt] = array[i];
				}
			}
			cnt++;
		}
		for(int i = 0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
