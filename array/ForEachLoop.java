package com.onebill.corejava.array;

public class ForEachLoop {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9};
		int sum=0;
		for(int x:arr) {
			sum += x;
		}
		System.out.println(sum + " " + sum/arr.length);
	}

}
