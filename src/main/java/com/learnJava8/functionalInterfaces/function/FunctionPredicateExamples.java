package com.learnJava8.functionalInterfaces.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class FunctionPredicateExamples {
	public static void main(String[] args) {
		FunctionPredicateExamples funcPredEx = new FunctionPredicateExamples();
		System.out.println("All students " + StudentDataBase.getAllStudents() + " \n");
		System.out.println(funcPredEx.getFunctionForStudentNameAndGPA().apply(StudentDataBase.getAllStudents()) + " \n ");
		System.out.println(funcPredEx.getFunctionForStudentNameAndAcitivitiesFiletrByGPAAndGrade().apply(StudentDataBase.getAllStudents()) + "\n");
	}
	
	public Function<List<Student>, Map<String, Double>> getFunctionForStudentNameAndGPA () {
		return (students) -> {
			Map<String, Double> stuNameGPAMap = new HashMap<String, Double>(students.size());
			students.forEach(student -> {
				stuNameGPAMap.put(student.getName(),student.getGpa());
			});
						
			return stuNameGPAMap;
		};
	}
	
	public Function<List<Student>, Map<String, List<String>>> getFunctionForStudentNameAndAcitivitiesFiletrByGPAAndGrade () {
		return (students) -> {
			Map<String, List<String>> stuNameGPAMap = new HashMap<String, List<String>>(students.size());
			students.forEach(student -> {
				if (getFilterClasueByCutOffGPAAndGrade(3,3.6).test(student.getGradeLevel(), student.getGpa())) {
					stuNameGPAMap.put(student.getName(), student.getActivityList());
				}
			});
						
			return stuNameGPAMap;
		};
	}
	
	private BiPredicate<Integer , Double> getFilterClasueByCutOffGPAAndGrade(final int cutOffGrade, final double cutOffGPA) {
		return (grade,gpa) -> grade >= cutOffGrade && gpa >= cutOffGPA;
	}
}
