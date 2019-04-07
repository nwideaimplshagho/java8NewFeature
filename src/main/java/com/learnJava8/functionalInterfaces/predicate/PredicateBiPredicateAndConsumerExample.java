package com.learnJava8.functionalInterfaces.predicate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class PredicateBiPredicateAndConsumerExample {

	private BiConsumer<String, List<String>> stuBiConsumerForNameAndAcitivities = (name,activities) -> {
		System.out.println(" Student name [" + name + "] and activities are [" + activities + "] \n");
	};
			
	public static void main(String[] args) {
		
		PredicateBiPredicateAndConsumerExample preBiPredConsumerExample = new PredicateBiPredicateAndConsumerExample();
		List<Student> studentList = StudentDataBase.getAllStudents();
		System.out.println("All Students " + studentList + " \n");
		preBiPredConsumerExample.printNameAndAcitivitesAfterFilteringByGradeAndGPA(studentList);
		preBiPredConsumerExample.printNameAndAcitivitesAfterFilteringByGradeAndGPAUsingBIConsumer(studentList);
	}
	
	public void printNameAndAcitivitesAfterFilteringByGradeAndGPA(List<Student> studentList) {
		System.out.println(" Print student name and activities filtering student grade 3 and gpa 3.6 level using predicate \n");
		studentList.forEach(getStudentConsumerByFilteringGradeAndGPAUsingPredicate(3, 3.6));
	}
	
	public void printNameAndAcitivitesAfterFilteringByGradeAndGPAUsingBIConsumer(List<Student> studentList) {
		System.out.println(" Print student name and activities filtering student grade 3and gpa 3.6 level using BiPredicate \n");
		studentList.forEach(getStudentConsumerByFilteringGradeAndGPAUsingBiPredicate(3, 3.6));
	}
	
	private Predicate<Student> getPredicateByCutoffGradeLevel(final int cutOffGrade) {
		return (student) -> student.getGradeLevel() >= cutOffGrade;
	}
		private Predicate<Student> getPredicateByCutOffGPA(final double cutOffGPA) {
		return (pupil) -> pupil.getGpa() >= cutOffGPA;
	}
	
	private BiPredicate<Integer, Double> getPredicateByCutOffGradeAndGPAUsingBiPredicate(final int cutOffGrade,final double cutOffGPA) {
		return (grade,gpa) -> grade >= cutOffGrade && gpa >= cutOffGPA;
	}
	
	private Consumer<Student> getStudentConsumerByFilteringGradeAndGPAUsingPredicate(final int cutOffGrade,final double cutOffGPA) {
		return (stu) -> {
			if (getPredicateByCutoffGradeLevel(cutOffGrade).and(getPredicateByCutOffGPA(cutOffGPA)).test(stu)) {
				getBiConsumerForNameAndActivities().accept(stu.getName(),stu.getActivityList());
			}
		};
	}
	
	private Consumer<Student> getStudentConsumerByFilteringGradeAndGPAUsingBiPredicate(final int cutOffGrade,final double cutOffGPA) {
		return (stu) -> {
			if (getPredicateByCutOffGradeAndGPAUsingBiPredicate(cutOffGrade, cutOffGPA).test(stu.getGradeLevel(),stu.getGpa())) {
				getBiConsumerForNameAndActivities().accept(stu.getName(),stu.getActivityList());
			}
		};
	}
	
	private BiConsumer<String, List<String>> getBiConsumerForNameAndActivities() {
		return (name,activities) -> {
			System.out.println(" Student name [" + name + "] and activities are [" + activities + "] \n");
		};
	}
}
