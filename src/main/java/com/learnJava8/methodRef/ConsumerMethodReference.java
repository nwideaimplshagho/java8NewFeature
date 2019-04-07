package com.learnJava8.methodRef;

import java.util.List;
import java.util.function.Consumer;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class ConsumerMethodReference {

	private static Consumer<Student> printStudents = System.out::println;
	private static Consumer<Student> printStudentActivitiesWithMethodRef = Student::printListOfActivities;
	
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		System.out.println("Print student using method ref ");
		studentList.forEach(printStudents);
		System.out.println("Print student activites using method ref");
		studentList.forEach(printStudentActivitiesWithMethodRef);
	}
}
