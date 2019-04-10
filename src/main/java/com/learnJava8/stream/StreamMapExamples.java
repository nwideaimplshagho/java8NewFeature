package com.learnJava8.stream;

import java.util.List;
import java.util.stream.Collectors;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StreamMapExamples {
	
	
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		studentList.stream()
		.peek(stud -> {
			System.out.println("### Before Map ##### " + stud +"\n");
		})
		.map(stu -> stu.getName())
		.peek(stud -> {
			System.out.println("### After Map to name ##### " + stud + "\n");
		})
		.map(nm -> nm.toUpperCase())
		.peek(stud -> {
			System.out.println("### After Map name to upeer case ##### " + stud + "\n");
		})
		.collect(Collectors.toList());
	}

}
