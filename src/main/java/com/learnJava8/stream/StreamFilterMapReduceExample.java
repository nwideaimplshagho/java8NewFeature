package com.learnJava8.stream;

import java.util.List;
import java.util.Optional;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StreamFilterMapReduceExample {
	public static void main(String[] args) {
		List<Student> studentList = StudentDataBase.getAllStudents();
		Optional<Integer> totalNoteBookCount = studentList.stream().map(Student::getNoteBook).reduce((noteBCount1,noteBCount2) -> noteBCount1+noteBCount2);
		totalNoteBookCount.ifPresent(count -> System.out.println("Total notebook count is =" + totalNoteBookCount));
		Optional<Integer> totalNoteBookCountForAllMales = studentList.stream().filter(stu -> stu.getGender().equalsIgnoreCase("male"))
				.map(Student::getNoteBook).reduce((noteBCount1,noteBCount2) -> noteBCount1+noteBCount2);
		totalNoteBookCountForAllMales.ifPresent(count -> System.out.println("Total notebook count for all males is =" + totalNoteBookCountForAllMales));
		Optional<Integer> totalNoteBookCountForAllMalesWithGradeGreaterEqual4 = studentList.stream()
				.filter(stu -> stu.getGender().equalsIgnoreCase("male")).peek(stu -> System.out.println("After gender filetr =" + stu))
				.filter(stu -> stu.getGradeLevel() >= 4).peek(stu -> System.out.println("After grade filter =" + stu))
				.map(Student::getNoteBook).reduce((note1,note2) -> note1+note2);
		totalNoteBookCountForAllMalesWithGradeGreaterEqual4
		.ifPresent(count -> System.out.println("Total notebook count for all males whose Grade greater than 4 is =" + totalNoteBookCountForAllMalesWithGradeGreaterEqual4));
		
	}
}
