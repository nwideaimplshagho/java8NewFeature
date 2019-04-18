package com.learnJava8.stream.numberStream;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumStreamSumMaxMinAvgExamples {

	public static void main(String[] args) {
		//Sum
		int sumOfInt = IntStream.rangeClosed(20, 80).peek(i -> System.out.println("Int number [" + i + "] for IntStream")).sum();
		System.out.println("Sum of int [" + sumOfInt + "] \n");
		long sumOfLong = LongStream.rangeClosed(15, 30).peek( l -> System.out.println("Long number [" + l + "] for LongStream")).sum();
		System.out.println("Sum of long [" + sumOfLong + "] \n");
		//Min
		OptionalLong minOptLong = LongStream.rangeClosed(10,50).min();
		System.out.println(minOptLong.isPresent() ? "Min val for long range 10,50 [" + minOptLong.getAsLong() + "] \n" : 0);
		
		OptionalDouble minOptDouble = IntStream.rangeClosed(50, 100).asDoubleStream().peek(d -> System.out.println("Double number [" + d + "] from IntStream")).min();
		System.out.println(minOptDouble.isPresent() ? "Min val for double range 50,100 [" + minOptDouble.getAsDouble() + "] \n" : 0);
		
		//Max 
		OptionalInt maxOptInt = IntStream.rangeClosed(10, 50).max();
		System.out.println(maxOptInt.isPresent() ? "Max val for int range 10,50 [" + maxOptInt.getAsInt() + "] \n" : 0);
		
		//Avg
		OptionalDouble avgOptDbl = IntStream.rangeClosed(10, 20).average();
		System.out.println(avgOptDbl.isPresent() ? "Avg val for int range 10,20 [" + avgOptDbl.getAsDouble() + "] \n" : 0);
	}

}
