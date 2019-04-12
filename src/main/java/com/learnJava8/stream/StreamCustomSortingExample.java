package com.learnJava8.stream;

import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StreamCustomSortingExample {
	
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		//Sort by Name
		System.out.println("Sort students by name = " + studentList.stream().sorted(Comparator.comparing(Student::getName)).collect(toList()));
		
		//Sort students by Name in reversed order
		System.out.println("Sort students by name in reverse order = " + studentList.stream().sorted(Comparator.comparing(Student::getName).reversed()).collect(toList()));
		
		//Sort by student grade 
		System.out.println("Sort student by grade = " + studentList.stream().sorted(Comparator.comparing(Student::getGradeLevel)).collect(toList()));
		
		//Sort by student grade in reverse order
		System.out.println("Sort student by grade = " + studentList.stream().sorted(Comparator.comparing(Student::getGradeLevel).reversed()).collect(toList()));
	}
}
