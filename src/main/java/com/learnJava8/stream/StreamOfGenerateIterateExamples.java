package com.learnJava8.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExamples {

	public static void main(String[] args) {
		Stream<String> allStrStream = Stream.of("Hello","Hi","Helloo","Hiii");
		allStrStream.forEach(s -> System.out.println("String value from stream created using Stream.of =" + s));
		
		Supplier<Integer> supplierRandomInt = new Random() :: nextInt;
		Stream.generate(supplierRandomInt).limit(10).forEach(num -> System.out.println("Stream of numbers ["+ num +"] using generate \n"));
		
		Stream.iterate(0, x -> x+2).limit(5).forEach(num -> System.out.println("Stream of numbers ["+ num +"] using ietrate \n"));
		
	}

}
