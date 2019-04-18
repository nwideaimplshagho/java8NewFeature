package com.learnJava8.stream.termianlStreamOps;

import static java.util.stream.Collectors.counting;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class TerminalCountingStream {

	public static void main(String[] args) {
		System.out.println("Counting student number [" + StudentDataBase.getAllStudents().stream().collect(counting()) + "] \n");
		System.out.println("Counting student notebooks [" + StudentDataBase.getAllStudents().stream().map(Student::getNoteBook).peek(nb -> System.out.println("Notebook " + nb)).collect(counting()) +"]");
	}

}
