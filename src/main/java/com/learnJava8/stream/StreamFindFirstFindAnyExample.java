package com.learnJava8.stream;

import java.util.List;
import java.util.Optional;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StreamFindFirstFindAnyExample {
	
	public static Optional<Student> findAnyStudentWIthHighGPA(List<Student> studentList,double cutOffGPA) {
		return studentList.stream().filter(stu -> stu.getGpa() > cutOffGPA).findAny();
	}
	
	public static Optional<Student> findFirstStudentWithHgighGrade(List<Student> studentList, int cutOffGrade) {
		return studentList.stream().filter(stu -> stu.getGradeLevel() > cutOffGrade).findFirst();
	}
	
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		
		double cutOffGPA = 3.6;
		Optional<Student> optionalStudentWithHighGPA = findAnyStudentWIthHighGPA(studentList,cutOffGPA);
		if (optionalStudentWithHighGPA.isPresent()) {
			System.out.println("Student with High GPA [" + cutOffGPA + "] or greater =" + optionalStudentWithHighGPA.get());
		} else {
			System.out.println("No student with GPA [" + cutOffGPA + "] or greater ");
		}
		
		int gradeLevel = 3;
		Optional<Student> firstStudentWithHighGrade = findFirstStudentWithHgighGrade(studentList,gradeLevel);
		if (firstStudentWithHighGrade.isPresent()) {
			System.out.println("Student with High Grade [" + gradeLevel + "] or higher =" + firstStudentWithHighGrade.get());
		} else {
			System.out.println("No student with Grade greater than [" + gradeLevel + "]");
		}
	}
}
