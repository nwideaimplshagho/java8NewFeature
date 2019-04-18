package com.learnJava8.stream.numberStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumStreamMapToObjMapToDoubleMapToLongExamples {

	public static List<Integer> mapToObj() {
		return IntStream.rangeClosed(1, 10).mapToObj(i -> new Integer(i)).collect(Collectors.toList());
	}
	
	public static Long mapToLong() {
		return IntStream.rangeClosed(10, 20).mapToLong( l -> l).sum();
	}
	
	public static Double mapToDouble() {
		return IntStream.rangeClosed(15,30).mapToDouble(d -> d).sum();
	}
	
	public static void main(String[] args) {
		System.out.println("Map to Object " + mapToObj() + "\n");
		System.out.println("Map to double " + mapToDouble() + "\n");
		System.out.println("Map to long " + mapToLong() + "\n");
	}

}
