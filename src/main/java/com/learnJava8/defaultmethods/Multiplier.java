package com.learnJava8.defaultmethods;

import java.util.List;

public interface Multiplier {
	public int multiply(List<Integer> intValList);
	
	default int itemSize(List<Integer> itemList) {
		System.out.println(" Multiplier Interface :: itemSize ");
		return itemList.size();
	}
	
	public static boolean isListEmpty(List<Integer> itemList) {
		return !(itemList != null && itemList.size() !=0);
	}
}
