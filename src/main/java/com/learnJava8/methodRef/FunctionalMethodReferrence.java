package com.learnJava8.methodRef;

import java.util.function.Function;

public class FunctionalMethodReferrence {

	public static void main(String[] args) {
		Function<String, String> toUpperWithoutMethodRef = (s) -> s.toUpperCase();
		System.out.println("Without using method reference =" + toUpperWithoutMethodRef.apply("Migrate to Java8") + "\n");
		Function<String, String> toUpperWithMethodRef = String::toUpperCase;
		System.out.println("With method reference =" + toUpperWithMethodRef.apply("Migrate to Java8"));
	}
}
