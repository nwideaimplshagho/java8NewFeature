package com.learnJava8.stream.parallelStream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class CompareStreamAndParallelStream {

	public static long  measureStreamPerf(Supplier<Integer> countStreamLogic,int countingLoop) {
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < countingLoop; i++) {
			countStreamLogic.get();
		}
		
		long endTime = System.currentTimeMillis();
//		System.out.println("Total time taken =" + (endTime - startTime));
		
		return (endTime - startTime);
	}
	
	public static int countByStream() {
		return IntStream.rangeClosed(1, 1000000).sum();
	}
	
	public static int countByParallelStream() {
		return IntStream.rangeClosed(1, 1000000).parallel().sum();
	}
	
	public static void main(String[] args) {
		System.out.println("Time taken by stream =" + measureStreamPerf(CompareStreamAndParallelStream::countByStream, 5));
		System.out.println("Time taken by parallel stream =" + measureStreamPerf(CompareStreamAndParallelStream::countByParallelStream, 5));
		
	}
}
