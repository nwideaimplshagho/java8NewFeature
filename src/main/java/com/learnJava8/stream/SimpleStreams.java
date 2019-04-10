package com.learnJava8.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class SimpleStreams {
	public static void main(String[] args) {
		
		Function<Student, String> getStudentNameMethRef = Student::getName;
		Function<Student, String> getStudentNmFunc = (student) -> student.getName();
		Function<Student, List<String>> getStudentActivityListMethRef = Student::getActivityList;
		Function<Student, List<String>> getStudentActivityListFunc = (stu) -> stu.getActivityList();
		
		Map<String, List<String>> stuNmActivityMapWithMthRef = StudentDataBase.getAllStudents().stream()
		.collect(Collectors.toMap(getStudentNameMethRef, getStudentActivityListMethRef));
		
//		System.out.println("All Students map with method Ref " + stuNmActivityMapWithMthRef + "\n");
		
		Map<String, List<String>> stuNmActivityMapWithFunc = StudentDataBase.getAllStudents().stream()
				.collect(Collectors.toMap(getStudentNmFunc, getStudentActivityListFunc));
		
//		System.out.println("All Students map with function " + stuNmActivityMapWithFunc + "\n");

		Map<String, List<String>> stuNmActivityMapFilterByGradeGreaterThanThree = StudentDataBase.getAllStudents().stream()
				.filter(stu -> stu.getGradeLevel() >= 3)
				.collect(Collectors.toMap(getStudentNmFunc, getStudentActivityListFunc));
//		System.out.println("Students map filter by grade >= 3 " + stuNmActivityMapFilterByGradeGreaterThanThree + "\n");
		
		Map<String, List<String>> stuNmActivityMapFilterByGradeAndGPA = StudentDataBase.getAllStudents().stream()
				.peek(student -> {
					System.out.println("############### Print All Students ############## [" + student + "] \n");
				})
				.filter(stu -> stu.getGradeLevel() >= 3)
				.peek(stu -> {
					System.out.println("############### Print students after applying grade filter [" + stu + "] \n");
				})
				.filter(stu -> stu.getGpa() >= 3.9)
				.peek(stu -> {
					System.out.println("############### Print students after applying gpa filter [" + stu + "] \n");
				})
				.collect(Collectors.toMap(getStudentNmFunc, getStudentActivityListFunc));
//		System.out.println("Students map grade >= 3 and gpa >= 3.9" + stuNmActivityMapFilterByGradeAndGPA + "\n");
		
		
	}
}
