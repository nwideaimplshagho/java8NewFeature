package com.learnJava8.stream.parallelStream;

import java.util.stream.IntStream;

public class AvoidParallelStreamUsageOne {
	
	public static void name() {
		
	}
	
	public static void main(String[] args) {
		CalculateSum cs = new CalculateSum();
		IntStream.rangeClosed(1, 1000).forEach(cs::performSum);
		System.out.println("Total result =" + cs.getTotal());
		cs.setTotal(0);
		IntStream.rangeClosed(1, 1000).parallel().forEach(cs::performSum);
		System.out.println("Total result using parallel =" + cs.getTotal());
	}

}
