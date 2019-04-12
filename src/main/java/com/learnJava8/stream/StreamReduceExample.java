package com.learnJava8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StreamReduceExample {
	
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		Optional<Student> studentWithHighestGrade = studentList.stream().reduce((s1,s2) -> {
			if (s1.getGradeLevel() > s2.getGradeLevel()) {
				return s1;
			} else {
				return s2;
			}
		});
		
		studentWithHighestGrade.ifPresent(stu -> System.out.println("Student with Highest grade =" + studentWithHighestGrade + "\n"));
		Optional<Student> studentWithLowestGrad = studentList.stream().reduce((s1,s2) -> {
			if (s1.getGradeLevel() < s2.getGradeLevel()) {
				return s1;
			} else {
				return s2;
			}
		});
		studentWithLowestGrad.ifPresent((stu) -> System.out.println("Student with lowest grade " + stu + "\n"));
		
		
		List<Integer> intsList = Arrays.asList(1,2,3,4);
		Optional<Integer> multiplicationOfNums = intsList.stream().reduce((a,b) -> a*b);
		multiplicationOfNums.ifPresent(res -> System.out.println("Multiplicaltion result is =" + res));
	}
}
