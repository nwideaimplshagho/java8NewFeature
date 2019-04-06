package com.learnJava8.functionalInterfaces.consumer;

import java.util.List;
import java.util.function.Consumer;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class LambdaConsumerExamples {
	private Consumer<Student> printStudents = stu -> System.out.println(stu);
	private Consumer<Student> printStuName = stu ->  System.out.print(" " + stu.getName() +" ");
	private Consumer<Student> printStuActivities = stu ->  System.out.println(stu.getActivityList());
	
	public static void main(String[] args) {
		LambdaConsumerExamples lConsumeEx = new LambdaConsumerExamples();
		List<Student> stduentList = StudentDataBase.getAllStudents();
		lConsumeEx.printStuents(stduentList);
		System.out.println();
		System.out.println("############################################");
		System.out.print("\n");
		lConsumeEx.printStudentsNameAndActivities(stduentList);
		System.out.println();
		System.out.println("#############################################");
		System.out.print("\n");
		lConsumeEx.printStudentsWithCondition(stduentList);
	}
	
	public void printStuents(List<Student> students) {
		System.out.println("Printing all students");
		students.forEach(printStudents);
	}
	
	public void printStudentsNameAndActivities(List<Student> students) {
		System.out.println("Printing student name and activities");
		students.forEach(printStuName.andThen(printStuActivities));
	}

	public void printStudentsWithCondition(List<Student> students) {
		System.out.println("Printing students with conditions");
		students.forEach(stu -> {
			if (stu.getGradeLevel() >= 2 && stu.getGradeLevel() > 3.9) {
				printStuName.andThen(printStuActivities).accept(stu);
			}
		});
	}
}
