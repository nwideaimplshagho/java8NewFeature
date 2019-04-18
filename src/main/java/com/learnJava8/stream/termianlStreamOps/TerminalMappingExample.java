package com.learnJava8.stream.termianlStreamOps;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class TerminalMappingExample {

	public static void main(String[] args) {
		System.out.println("Get student names using terminal mapping " + StudentDataBase.getAllStudents().stream().collect(mapping(Student::getName, toList())));
		System.out.println("Get student names using stream mapping extra step " + StudentDataBase.getAllStudents().stream().map(Student::getName).collect(toList())) ;
	}

}
