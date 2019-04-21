package com.learnJava8.stream.parallelStream;

public class CalculateSum {
	private  volatile int total=0;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void performSum(int value) {
		this.total+= value;
	}
}
