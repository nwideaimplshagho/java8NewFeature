package com.learnJava8.optional;

import java.util.Optional;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class Java8OptionalOfNullableEmpty {
	
	public static Optional<String> ofNullableExample(Student stu) {
		Optional<String> optGender = Optional.ofNullable(stu).map(Student::getGender);
		return optGender;
	}
	
	public static Optional<String> ofExample(Student stu) {
		Optional<String> optGender = Optional.of(stu).map(Student::getGender);
		return optGender;
	}
	
	public static void main(String[] args) {
//		Student stu = StudentDataBase.studentSupplier.get();
		Student stu = null;
		System.out.println("Get gender by OfNullable " + ofNullableExample(stu));
		System.out.println("Get gender by Of  " + ofExample(stu));
	}

}
