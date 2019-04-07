package com.learnJava8.functionalInterfaces.function;

import java.util.function.BinaryOperator;

public class BinaryOprExample {

	public static void main(String[] args) {
		BinaryOperator<Integer> addionOpe = (numFs,numSd) -> {
			return numFs+numSd;
		};
		
		BinaryOperator<Double> multiplicationOpe = (n1,n2) -> {
			return n1*n2;
		};
		
		System.out.println("Addtion result " + addionOpe.apply(10, 20) + ", multiplication reseult " + multiplicationOpe.apply(10d, 20d));
	}
}
