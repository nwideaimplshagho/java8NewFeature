package com.learnJava8.stream;

import java.util.List;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StreamAllMatchAnyMatchNoneMathExample {

	public static boolean getAnyMatchingStudentByGpa(List<Student> studentList) {
		return studentList.stream().anyMatch(stu -> stu.getGpa() >= 3.5);
	}
	
	public static boolean getAllMatchingStudentByGrade(List<Student> studentList) {
		return studentList.stream().allMatch(stu -> stu.getGradeLevel() >= 2);
	}
	
	public static boolean getNoneMatchOfStudents(List<Student> studentList) {
		return studentList.stream().noneMatch(stu -> stu.getGradeLevel() >= 5);
	}
	
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		System.out.println("Result of any match= " + getAnyMatchingStudentByGpa(studentList));
		System.out.println("Result of all match= " + getAllMatchingStudentByGrade(studentList));
		System.out.println("Result of none match= " + getNoneMatchOfStudents(studentList));
	}
}
