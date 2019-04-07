package com.learnJava8.methodRef;

import java.util.function.Function;
import java.util.function.Supplier;

import com.learnJava8.data.Student;

public class ConstructorReferenceMethodRef {
	private static Supplier<Student> studentupplier = Student::new;
	private static Function<String, Student> studentCreateFunc = Student::new;
	
	public static void main(String[] args) {
		System.out.println("Create new student using constructor method ref =" + studentupplier.get() + "\n");
		System.out.println("Create new student with name constructor method ref =" + studentCreateFunc.apply("Josh") + "\n");
	}
}
