package com.learnJava8.optional;

import java.util.Optional;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class Java8OptionalExample {

	public static String getStudetName(Student stu) {
		String name = null;
		if (stu != null) {
			name = stu.getName();
		}
		
		return name;
	}
	
	public static Optional<String> getStudentNameOpional(Student student) {
		Optional<Student> stuOptional = Optional.ofNullable(student);
		Optional<String> nameOpt = stuOptional.isPresent()? stuOptional.map(Student::getName):Optional.empty();
		return nameOpt;	
	}
	public static void main(String[] args) {
		Student stu = StudentDataBase.studentSupplier.get();
//		Student stu = null;
		String name = getStudetName(stu);
		if (name != null) {
			System.out.println("Get name = " + name);
		} else {
			System.out.println("No student found");
		}
		
		Optional<String> stuNameOpt = getStudentNameOpional(stu);
		if (stuNameOpt.isPresent()) {
			System.out.println("Get name = " + stuNameOpt.get() + " using optional");
		} else {
			System.out.println("No student found with optional " + stuNameOpt);
		}
		
	}

}
