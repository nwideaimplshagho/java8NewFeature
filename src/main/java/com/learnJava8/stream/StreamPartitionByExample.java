package com.learnJava8.stream;

import java.util.List;
import java.util.Map;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

import static java.util.stream.Collectors.*;

public class StreamPartitionByExample {

	public static void partitionByOne(List<Student> students) {
		Map<Boolean, List<Student>> studentMap = students.stream().collect(partitioningBy(stu -> stu.getGradeLevel() > 3));
		System.out.println("Matching = " + studentMap.get(Boolean.TRUE));
		System.out.println("Not Matching = " + studentMap.get(Boolean.FALSE));
	}
	
	public static void partitionByTwoArgu(List<Student> students) {
		Map<Boolean, Integer> studentMap = students.stream().collect(partitioningBy(stu -> stu.getGradeLevel() > 3,summingInt(Student::getGradeLevel)));
		System.out.println("Matching = " + studentMap.get(Boolean.TRUE));
		System.out.println("Not Matching = " + studentMap.get(Boolean.FALSE));
	}
	
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		partitionByOne(studentList);
		partitionByTwoArgu(studentList);
	}

}
