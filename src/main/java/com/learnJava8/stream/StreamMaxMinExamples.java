package com.learnJava8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMaxMinExamples {
	
	public static int getMaxNumWithDefaultVal(List<Integer> intNumList) {
		return intNumList.stream().reduce(0, (x,y) -> x > y? x :y);
	}
	
	public static Optional<Integer> getMaxNumWithOptional(List<Integer> intNumList) {
		return intNumList.stream().reduce((x,y) -> x > y ? x : y);
	}
	
	public static Optional<Integer> getMinNumWithOptional(List<Integer> intNumList) {
		return intNumList.stream().reduce((x,y) -> x < y ? x : y);
	}
	
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(6,7,8,9,10);
//		List<Integer> intList = new ArrayList<Integer>();
		int maxNum = getMaxNumWithDefaultVal(intList);
		System.out.println("Max num with default = " + maxNum);
		
		Optional<Integer> maxNumWithOptional = getMaxNumWithOptional(intList);
		if (maxNumWithOptional.isPresent()) {
			System.out.println("Max num with optinal =" + maxNumWithOptional.get());
		} else {
			System.out.println(" Input list ios empty ");
		}
		Optional<Integer> minNumWithOptional = getMinNumWithOptional(intList);
		if (minNumWithOptional.isPresent()) {
			System.out.println("Min num with optinal =" + minNumWithOptional.get());
		} else {
			System.out.println(" Input list ios empty ");
		}
	}

}
