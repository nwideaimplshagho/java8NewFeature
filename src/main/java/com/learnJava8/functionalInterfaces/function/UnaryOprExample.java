package com.learnJava8.functionalInterfaces.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class UnaryOprExample {

	public static void main(String[] args) {
		
		UnaryOprExample unOpEx = new UnaryOprExample();
		List<Student> allStudents = StudentDataBase.getAllStudents();
		System.out.println("All students =" + allStudents + " \n ");
		System.out.println("Get all male students having grade > 3 " + unOpEx.getStudentsFilteredByGenderAndGrade("male", 3).apply(allStudents) + " \n ");
	}
	
	public UnaryOperator<List<Student>> getStudentsFilteredByGenderAndGrade(final String stuGender,final int stuGrade) {
		return (students) -> {
			List<Student> stuListByGenderAndGrade = new ArrayList<>();
			students.forEach(student -> {
				if(filterStudentsByGenderAndGrade(stuGender, stuGrade).test(student.getGender(), student.getGradeLevel())) {
					stuListByGenderAndGrade.add(student);
				}
			});
			return stuListByGenderAndGrade;
		};
	}
	
	private BiPredicate<String, Integer> filterStudentsByGenderAndGrade(final String stuGender,final int stuGrade) {
		return (gender,grade) -> gender.equalsIgnoreCase(stuGender) && grade >= stuGrade;
	}
}
