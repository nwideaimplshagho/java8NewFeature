package com.learnJava8.functionalInterfaces.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class PredicateFunctionalInterfaceExamples {

	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		System.out.println("List all students [" + studentList + "] \n");
		
		PredicateFunctionalInterfaceExamples predFuncEx = new PredicateFunctionalInterfaceExamples();
		final int cutOffGrade = 3;
		final double cutOffGPA = 3.9;
		predFuncEx.printStudentsByGPA(studentList, cutOffGPA);
		predFuncEx.printStudentsByGrade(studentList, cutOffGrade);
		predFuncEx.printStudentsByCutOffGradeLevelAndGPA(studentList, cutOffGrade, cutOffGPA);
		predFuncEx.prinStudentsByThresholdGradeLevelOrGPA(studentList, cutOffGrade, cutOffGPA);
	}
	
	public void printStudentsByGrade(List<Student> pupiLs,final int cutOffGrade) {
		System.out.println("Getting students by cut off Grade Level [" + cutOffGrade + "] \n");
		
		Predicate<Student> filterStudentByGrade = getPredicateByStudentGrade(cutOffGrade);
		final List<Student> studentsAboveCutoffGrade = new ArrayList<Student>();
		pupiLs.forEach(pupil -> {
			if (filterStudentByGrade.test(pupil)) {
				studentsAboveCutoffGrade.add(pupil);
			}
		});
		
		System.out.println("Students [" + studentsAboveCutoffGrade + "] above cut off grade = [" + cutOffGrade + "] \n");
	}
	
	public void printStudentsByGPA(List<Student> pupiLs,final double cutOffGPA) {
		System.out.println("Getting students by cut off GPA Level [" + cutOffGPA + "] \n");
		
		Predicate<Student> filterStudentByGPA = getPredicateByStudentGPALevel(cutOffGPA);
		final List<Student> studentsAboveCutoffGPA = new ArrayList<Student>();
		pupiLs.forEach(pupil -> {
			if (filterStudentByGPA.test(pupil)) {
				studentsAboveCutoffGPA.add(pupil);
			}
		});
		
		System.out.println("Students [" + studentsAboveCutoffGPA + "] above cut off GPA = [" + cutOffGPA + "] \n");

	}
	
	public void printStudentsByCutOffGradeLevelAndGPA(List<Student> pupilList,final int cutOffGrade, final double cutOffGPA) {
		System.out.println("Getting students by cut off GPA Level [" + cutOffGPA + "] and grade [" + cutOffGrade + "] \n");
		Predicate<Student> filterStudentByGrade = getPredicateByStudentGrade(cutOffGrade);
		Predicate<Student> filterStudentByGPA = getPredicateByStudentGPALevel(cutOffGPA);
		
		final List<Student> studentListAboveThresholdGradeAndGPA = new ArrayList<Student>();
		pupilList.forEach(student -> {
			if (filterStudentByGrade.and(filterStudentByGPA).test(student)) {
				studentListAboveThresholdGradeAndGPA.add(student);
			}
		});
		
		System.out.println("Filtered stduents [" + studentListAboveThresholdGradeAndGPA + "] \n");
	}
	
	public void prinStudentsByThresholdGradeLevelOrGPA(List<Student> pupilList,final int cutOffGrade, final double cutOffGPA) {
		System.out.println("Getting students by cut off GPA Level [" + cutOffGPA + "] Or grade [" + cutOffGrade + "] \n");
		Predicate<Student> filterStudentByGrade = getPredicateByStudentGrade(cutOffGrade);
		Predicate<Student> filterStudentByGPA = getPredicateByStudentGPALevel(cutOffGPA);
		
		final List<Student> studentListAboveThresholdGradeAndGPA = new ArrayList<Student>();
		pupilList.forEach(student -> {
			if (filterStudentByGrade.or(filterStudentByGPA).test(student)) {
				studentListAboveThresholdGradeAndGPA.add(student);
			}
		});
		
		System.out.println("Filtered stduents [" + studentListAboveThresholdGradeAndGPA + "] \n");
	}
	
	private Predicate<Student> getPredicateByStudentGrade(final int cutOffGrade) {
		return (stu) -> stu.getGradeLevel() >= cutOffGrade;
	}
	
	private Predicate<Student> getPredicateByStudentGPALevel(final double cutOffGPA) {
		return (stu) -> stu.getGpa() >= cutOffGPA;
	}
}
