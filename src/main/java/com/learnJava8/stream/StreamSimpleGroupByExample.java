package com.learnJava8.stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.minBy;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StreamSimpleGroupByExample {

	public static void simpleGroupBy(List<Student> studentList) {
		Map<String, List<Student>> studentMap = studentList.stream().collect(groupingBy(Student::getName));
		System.out.println(studentMap);
	}

	public static void simpleGroupByCustomize(List<Student> studentList) {
		Map<String, List<Student>> studentMap = studentList.stream()
				.collect(groupingBy(student -> student.getGradeLevel() > 3.6 ? "AVERAGE" : "OUTSTANDING"));
		System.out.println(studentMap);
	}

	public static void groupByGradeAndThenName(List<Student> studentList) {
		Map<Integer, Map<String, List<Student>>> studentMap = studentList.stream()
				.collect(groupingBy(Student::getGradeLevel, groupingBy(Student::getName)));
		System.out.println(studentMap);
	}

	public static void groupByNameAndTotalNoteBookCount(List<Student> studentList) {
		Map<String, Integer> studentMap = studentList.stream()
				.collect(groupingBy(Student::getName, summingInt(Student::getNoteBook)));
		System.out.println(studentMap);
	}

	public static void threeArguGroupByNameKey(List<Student> studentList) {
		Map<String, List<Student>> studentMap = studentList.stream()
				.collect(groupingBy(Student::getName, LinkedHashMap::new, toList()));
		System.out.println(studentMap);
	}

	public static void threeArguGroupByWithGradeKey(List<Student> studentList) {
		Map<Integer, List<Student>> studentMap = studentList.stream()
				.collect(groupingBy(Student::getGradeLevel, LinkedHashMap::new, toList()));
		System.out.println(studentMap);
	}

	public static void calculateMaxGPA(List<Student> studentList) {
		Map<Integer, Optional<Student>> studentMapWithOptional = studentList.stream()
				.collect(groupingBy(Student::getGradeLevel, maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println("Max GPA with optional " + studentMapWithOptional);

		Map<Integer, Student> studentMap = studentList.stream().collect(groupingBy(Student::getGradeLevel,
				collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		System.out.println("Max GPA without optional " + studentMap);
	}

	public static void calculateMinGPA(List<Student> studentList) {
		Map<Integer, Optional<Student>> studentMapWithOptional = studentList.stream()
				.collect(groupingBy(Student::getGradeLevel, minBy(Comparator.comparing(Student::getGpa))));
		System.out.println("Min GPA with optional " + studentMapWithOptional);

		Map<Integer, Student> studentMap = studentList.stream().collect(groupingBy(Student::getGradeLevel,
				collectingAndThen(minBy(Comparator.comparing(Student::getGpa)), Optional::get)));
		System.out.println("Min GPA without optional " + studentMap);

	}

	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
//		simpleGroupBy(studentList);
//		simpleGroupByCustomize(studentList);
//		groupByGradeAndThenName(studentList);
//		groupByNameAndTotalNoteBookCount(studentList);
//		threeArguGroupByNameKey(studentList);
//		threeArguGroupByWithGradeKey(studentList);
		calculateMaxGPA(studentList);
		calculateMinGPA(studentList);
	}
}
