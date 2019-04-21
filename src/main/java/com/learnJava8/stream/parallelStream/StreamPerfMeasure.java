package com.learnJava8.stream.parallelStream;

import java.util.List;
import java.util.stream.Collectors;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StreamPerfMeasure {

	public static List<String> streamPrintStudentActivityList(List<Student> studentList) {
		long startTime = System.currentTimeMillis();
		
		List<String> activityList = studentList.stream().map(Student::getActivityList).flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime));
		
		return activityList;
	}
	
	public static List<String> parallelStreamPrintStudentActivityList(List<Student> studentList) {
		long startTime = System.currentTimeMillis();
		List<String> activityList = studentList.parallelStream().map(Student::getActivityList).flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime));
		return activityList; 
	}
	
	public static void main(String[] args) {
		System.out.println("Available processor count " + Runtime.getRuntime().availableProcessors());
		List<Student> studentList = StudentDataBase.getAllStudents();
		parallelStreamPrintStudentActivityList(studentList);
		streamPrintStudentActivityList(studentList);
	}

}
