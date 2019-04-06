package com.study.java8ver.feature.exmpls.lambadaEx;

import java.util.Comparator;

public class LambdaEx {
	public static void main(String[] args) {
		LambdaEx lEx = new LambdaEx();
		lEx.runnableUsingLambda();
		lEx.runnableUsingLambdaShortExpr();
		lEx.comparatorUsingLambda();
	}
	
	public void runnableUsingLambda() {
		Runnable runLong = () -> System.out.println("Runable using labmda");
		Thread thRun = new Thread(runLong);
		thRun.start();
	}
	
	public void runnableUsingLambdaShortExpr() {
		/**
		 * Runnable using lamda expression
		 */
		Thread thRunShort = new Thread(()->System.out.println("Runable using labmda in short expression"));
		thRunShort.start();
	} 
	
	public void comparatorUsingLambda() {
		Comparator<Integer> comparatorUsingLamda = (a,b) -> {
			
			return a.compareTo(b);
		};
		System.out.println("Comparator 10,20 using lambda " + comparatorUsingLamda.compare(10, 20));
	}
	
}
