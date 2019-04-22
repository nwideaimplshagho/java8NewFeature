package com.learnJava8.defaultmethods;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class SimpleDefaultMethod {
	
	private static Consumer<String> nameConsumer = (name) -> System.out.print(" Name = " + name);
	private static Consumer<Student> studentNameGenderGradeGpaConsumer = (stu) -> {
		if (stu == null) {
			System.out.println(" No student present");
		} else {
			System.out.println(" Name = " + stu.getName() + ", gender = " + stu.getGender()
			+ ", grade =" + stu.getGradeLevel() + ", gpa =" + stu.getGpa());
		}
	};
	
	private static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
	private static Comparator<Student> gpaComparator = Comparator.comparing(Student::getGpa);
	
	private static void sortByName(List<Student> students) {
		System.out.println(" After sortByName ");
		students.sort(nameComparator);
		students.forEach(studentNameGenderGradeGpaConsumer);
	}
	
	private static void sortByGpa(List<Student> students) {
		System.out.println(" After sortByGpa ");
		students.sort(gpaComparator);
		students.forEach(studentNameGenderGradeGpaConsumer);
	}
	
	private static void sortChaining(List<Student> students) {
		System.out.println(" After sortChaining ");
		students.sort(nameComparator.thenComparing(gpaComparator));
		students.forEach(studentNameGenderGradeGpaConsumer);
	}
	
	private static void sortByNameNullFirst(List<Student> students) {
		System.out.println(" After sort by name null first");
		students.sort(Comparator.nullsFirst(nameComparator));
		students.forEach(studentNameGenderGradeGpaConsumer);
	}
	
	private static void sortByGpaNullLast(List<Student> students) {
		System.out.println(" After sort by GPA null last");
		students.sort(Comparator.nullsLast(gpaComparator));
		students.forEach(studentNameGenderGradeGpaConsumer);
	}
	
	public static void main(String[] args) {
		List<String> studentNames = StudentDataBase.getAllStudents().stream().map(Student::getName).collect(Collectors.toList());
		studentNames.forEach(nameConsumer);
		//Sort before Java 8
		Collections.sort(studentNames);
		System.out.println("\n Before Java 8 using Collections.sort " + studentNames);
		//Sort after Java 8 using List.sort
		
		studentNames.sort(Comparator.naturalOrder());
		System.out.println("\n After Java 8 using List.sort " + studentNames);
		List<Student> students = StudentDataBase.getAllStudents();
		sortByName(students);
		sortByGpa(students);
		sortChaining(students);
		List<Student> studentsWithNullVal = StudentDataBase.getAllStudentsWithOneNullValue();
		sortByNameNullFirst(studentsWithNullVal);
		sortByGpaNullLast(studentsWithNullVal);
	}
}
	