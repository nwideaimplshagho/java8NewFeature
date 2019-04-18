package com.learnJava8.stream.numberStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumberStreamExample {

	public static int sumOfNumbers(List<Integer> nums) {
		return nums.stream().reduce(0, (x,y) -> x+y);
	}
	
	public static int sumOfNumbersWithIntStream() {
		return IntStream.rangeClosed(1,6).sum();
	}
	
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		System.out.println("Sum of numbers from 1 to 6 using reduce = " + sumOfNumbers(nums));
		
		System.out.println("Sum of numbers using int stream = " + sumOfNumbersWithIntStream());
		
	}
}
