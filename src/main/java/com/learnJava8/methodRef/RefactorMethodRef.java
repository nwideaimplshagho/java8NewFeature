package com.learnJava8.methodRef;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class RefactorMethodRef {
	
	private static Predicate<Integer> filterByGradeWithMethodRef= RefactorMethodRef::greaterThanGrade;
	private static BiPredicate<Integer, Double> filterByGradeAndGPAWithMethodRef = RefactorMethodRef:: greaterThanGradeAndGPA;
	
	private static boolean greaterThanGrade(final int grade) {
		return grade >= 3;
	}
	
	private static boolean greaterThanGradeAndGPA(final int grade,final double gpa) {
		return grade >= 3 && gpa >= 3.9;
	}
	
	public static void main(String[] args) {
		Student stu = StudentDataBase.getAllStudents().get(4);
		System.out.println("Student grade greater than equal 3 =" + filterByGradeWithMethodRef.test(stu.getGradeLevel()) + " \n ");
		System.out.println("Student grade greater than equal 3 and GPA greater than equal 3.9 =" + filterByGradeWithMethodRef.test(stu.getGradeLevel()) + " \n ");
		stu = StudentDataBase.getAllStudents().get(1);
		System.out.println("Student grade greater than equal 3 =" + filterByGradeWithMethodRef.test(stu.getGradeLevel()) + " \n ");
		System.out.println("Student grade greater than equal 3 and GPA greater than equal 3.9 =" + filterByGradeWithMethodRef.test(stu.getGradeLevel()) + " \n ");
	}
}
