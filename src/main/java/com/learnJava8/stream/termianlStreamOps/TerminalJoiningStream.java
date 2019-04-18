package com.learnJava8.stream.termianlStreamOps;

import java.util.List;
import static java.util.stream.Collectors.joining;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class TerminalJoiningStream {

	public static String simpleJoining(List<Student> studentList) {
		return studentList.stream().map(Student::getName).collect(joining());
	}
	
	public static String joiningUsingDelimiter(List<Student> studentList) {
		return studentList.stream().map(Student::getName).collect(joining(","));
	}
	
	public static String joiningUsingDelimiterSuffixPrefix(List<Student> stduentList) {
		return stduentList.stream().map(Student::getName).collect(joining(",", "(", ")"));
	}
	
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		System.out.println("Simple joining " + simpleJoining(studentList) + "\n");
		System.out.println("Joining using delimiter " + joiningUsingDelimiter(studentList) +"\n");
		System.out.println("Joining using delimiter, suffix and prefix " + joiningUsingDelimiterSuffixPrefix(studentList) + "\n");
	}

}
