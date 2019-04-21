package com.learnJava8.optional;

import java.util.Optional;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;
import com.learnJava8.data.Tution;

public class OptionalFilterFlatMapExample {
	
	public static void filterExample(Student stu) {
		Optional.ofNullable(stu).filter(student -> student.getGradeLevel() > 2)
			.ifPresent( (student) -> System.out.println("filter :: Name is = " + student.getName()));
	}
	
	public static void optionalMap(Student stu) {
		Optional<Student> optStu = Optional.ofNullable(stu);
		if (optStu.isPresent()) {
			optStu.map(Student::getName).ifPresent(name -> System.out.println("map :: Name is = " + name));
		}
	}
	
	public static void optionalFlatMap(Student student) {
		Optional<String> tutionName = Optional.ofNullable(student).filter(stu -> stu.getGradeLevel() >= 2).flatMap(Student::getTution).map(Tution::getName);
		tutionName.ifPresent(name -> System.out.println("Tution subject name is = " + tutionName.get()));
	}
	
	public static void main(String[] args) {
		Student stu = StudentDataBase.studentSupplier.get();
		filterExample(stu);
		optionalMap(stu);
		optionalFlatMap(stu);
	}
}
