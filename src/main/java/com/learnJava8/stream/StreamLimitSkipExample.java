package com.learnJava8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamLimitSkipExample {

	public static Optional<Integer> sumNumbersAfterLimitingTotalCount(List<Integer> numberList, int limitSize) {
		return numberList.stream().limit(limitSize).reduce((x,y) -> x+y);
	}
	
	public static Optional<Integer> avgNumbersAfterSkipingNumberes(List<Integer> numbers, int skipSize) {
		return numbers.stream().skip(skipSize).reduce((x,y) -> (x+y)/2);
	}
	public static void main(String[] args) {
		List<Integer> intValueList = Arrays.asList(8,10,7,4,20,16);
		
		Optional<Integer> resultSumAfterLimitingNumbers = sumNumbersAfterLimitingTotalCount(intValueList, intValueList.size() - 3);
		if (resultSumAfterLimitingNumbers.isPresent()) {
			System.out.println("Sum after limiting the size of list [" + (intValueList.size() - 3) + "] is =" + resultSumAfterLimitingNumbers.get());
		} else if (intValueList.isEmpty()) {
			System.out.println("Input list is empty");
		}
		
		Optional<Integer> resultAvgNumAfterSkipNumbers = avgNumbersAfterSkipingNumberes(intValueList, intValueList.size() -3);
		
		if (resultAvgNumAfterSkipNumbers.isPresent()) {
			System.out.println("Avg after skipping num count [" + (intValueList.size() - 3) + "] is =" + resultAvgNumAfterSkipNumbers.get());
		} else if (intValueList.isEmpty()) {
			System.out.println("Input list is empty");
		}
	}
}
