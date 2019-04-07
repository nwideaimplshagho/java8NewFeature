package com.learnJava8.functionalInterfaces.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class StudentSupplierExample {

	public static void main(String[] args) {
		StudentSupplierExample stuSupplEx = new StudentSupplierExample();
		System.out.println(" All students " + StudentDataBase.getAllStudents() + "\n") ;
		System.out.println(" All students in gymnastics " + stuSupplEx.getStudentsBySelectedActivity("gymnastics").get() + "\n");
	}
	
	private Supplier<List<Student>> getStudentsBySelectedActivity(String activity) {
		
		return () -> {
			List<Student> students = StudentDataBase.getAllStudents();
			Predicate<Student> filerByActivity = (stu) -> stu.getActivityList().contains(activity);
			List<Student> stdBySelectedActivity = new ArrayList<>(students.size());
			students.forEach(stu -> {
				if (filerByActivity.test(stu)) {
					stdBySelectedActivity.add(stu);
				}
			});
			
			return stdBySelectedActivity;
		};
	}
}
