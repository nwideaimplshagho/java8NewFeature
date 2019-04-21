package com.learnJava8.optional;

import java.util.Optional;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class OptionalOrElseGetThrowExamples {

	public static String orElse(Student stu) {
		Optional<Student> studentOpt = Optional.ofNullable(stu);
		return studentOpt.map(Student::getName).orElse("Admin");
	}
	
	public static String orElseGet(Student stu) {
		return Optional.ofNullable(stu).map(Student::getName).orElseGet(() -> "Admin");
	}
	
	public static String orElseThrow(Student stu) {
		return Optional.ofNullable(stu).map(Student::getName).orElseThrow(() -> new RuntimeException("No student available"));
	}
	
	public static void main(String[] args) {
//		Student stu = StudentDataBase.studentSupplier.get();
		Student stu = null;
		System.out.println("Or Else = " + orElse(stu));
		System.out.println("Or Else Get = " + orElseGet(stu));
		System.out.println("Or Else throw = " + orElseThrow(stu));
	}

}
