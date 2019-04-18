package com.learnJava8.stream.termianlStreamOps;

import java.util.List;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.maxBy;
import java.util.Comparator;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class TerminalMinByMaxByExamples {

	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		System.out.println("Student with min GPA " + studentList.stream().collect(minBy(Comparator.comparing(Student::getGpa))));
		System.out.println("Student with max GPA " + studentList.stream().collect(maxBy(Comparator.comparing(Student::getGpa))));
	}
}
