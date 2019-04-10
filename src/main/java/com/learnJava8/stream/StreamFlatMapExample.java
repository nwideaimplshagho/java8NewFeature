package com.learnJava8.stream;

import java.util.List;

import static java.util.stream.Collectors.toList;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StreamFlatMapExample {
	
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		//Convert List<Student> to List<String>
		List<String> stuActivityListSorted = studentList.stream().map(Student::getActivityList)//Retruns Stream<List<String>>
				.flatMap(List::stream).sorted().collect(toList());
		System.out.println("Student activites in soretd order = " + stuActivityListSorted + "\n");
		List<String> uniqueStudentActivity = studentList.stream().map(Student::getActivityList)//Retruns Stream<List<String>>
				.flatMap(List::stream).distinct().collect(toList());
		System.out.println("Unique Student activites  = " + uniqueStudentActivity + "\n");
		long uniqueStudentActivityCount = studentList.stream().map(Student::getActivityList).flatMap(List::stream)
				.distinct().count();
		System.out.println("Unique Student activites count  = " + uniqueStudentActivityCount + "\n");
	}

}
