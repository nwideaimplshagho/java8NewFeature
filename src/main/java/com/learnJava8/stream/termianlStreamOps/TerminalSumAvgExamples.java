package com.learnJava8.stream.termianlStreamOps;

import java.util.List;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.averagingInt;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;


public class TerminalSumAvgExamples {
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		int noteBookCount = studentList.stream().collect(summingInt(Student::getNoteBook));
		System.out.println("Total notebooks " + noteBookCount + "\n");
		double avgNotePerStudent = studentList.stream().collect(averagingInt(Student::getNoteBook));
		System.out.println("Avg number of notebooks " + avgNotePerStudent + "\n");
	}
}
