package com.learnJava8.functionalInterfaces.function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class BiFunctionUsingBiPredicateExample {
	
	public static void main(String[] args) {
		BiFunctionUsingBiPredicateExample biFuncUsingBiPredEx = new BiFunctionUsingBiPredicateExample();
		List<Student> students = StudentDataBase.getAllStudents();
		System.out.println("All students " + students + " \n");
		biFuncUsingBiPredEx.getStudentNameWithGPAMapByCutOffGradeAndGPA(StudentDataBase.getAllStudents(),3, 3.9);
	}
	
	public void getStudentNameWithGPAMapByCutOffGradeAndGPA(List<Student> students,final int cutOffGrade, final double cutOffGPA) {
		System.out.println("Student by Name and Grade =" + getStudentFuncFilteredByCutOfffGradeAndGPA().apply(students,getFilterClasueByCutOffGPAAndGrade(cutOffGrade, cutOffGPA)) + " \n ");
	}
	
	private BiFunction<List<Student>, BiPredicate<Integer, Double>, Map<String, Double>> getStudentFuncFilteredByCutOfffGradeAndGPA() {
		
		return (students,biPredfilerByGradeGPA) -> {
			Map<String, Double> stuNameGPAMap = new HashMap<String, Double>();
			
			students.forEach(stu -> {
				if (biPredfilerByGradeGPA.test(stu.getGradeLevel(), stu.getGpa())) {
					stuNameGPAMap.put(stu.getName(),stu.getGpa());
				}
			});
			
			return stuNameGPAMap;
		};
	}

	private BiPredicate<Integer , Double> getFilterClasueByCutOffGPAAndGrade(final int cutOffGrade, final double cutOffGPA) {
		return (grade,gpa) -> grade >= cutOffGrade && gpa >= cutOffGPA;
	}
}
