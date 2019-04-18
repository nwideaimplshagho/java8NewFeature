package com.learnJava8.stream.numberStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumStreamBoxingUnboxingMaptoIntExamples {
	
	public static List<Integer> boxingToWrapper() {
		return IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
	}
	
	public static int unBoxToPremitive(List<Integer> intNumList) {
		return intNumList.stream().mapToInt( i -> i.intValue()).sum();
	}
	
	public static void main(String[] args) {
		List<Integer> intNumList = boxingToWrapper();

		System.out.println("Boxing numbers " + boxingToWrapper() + " \n");
		System.out.println("Unboxing numbers [" + unBoxToPremitive(intNumList)+ "] \n");
	}
}
