package com.learnJava8.defaultmethods;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultiplierImpl implements Multiplier {

	@Override
	public int multiply(List<Integer> intValList) {
		int result = 0;
		if (!Multiplier.isListEmpty(intValList)) {
			result = intValList.stream().reduce(1, (x,y) -> x*y);
		}
		return result;
	}
	
	//Can override default method 
	@Override
	public int itemSize(List<Integer> itemList) {
		System.out.println("MultiplierImpl :: itemSize ");
		return itemList.size();
	}
	
	public static void main(String[] args) {
		
		Multiplier multiplier = new MultiplierImpl();
		List<Integer> intValList = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
		System.out.println(" Result of multiplication = " + multiplier.multiply(intValList));
		System.out.println(" Default method to get list size = " + multiplier.itemSize(intValList));
		System.out.println(" Static method to check list is empty = " + Multiplier.isListEmpty(intValList));
	}

}
