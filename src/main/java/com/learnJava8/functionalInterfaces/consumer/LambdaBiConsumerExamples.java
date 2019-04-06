package com.learnJava8.functionalInterfaces.consumer;

import java.util.List;
import java.util.function.BiConsumer;

import com.learnJava8.data.Student;
import com.learnJava8.data.StudentDataBase;

public class LambdaBiConsumerExamples {

	private BiConsumer<Integer, Integer> multiply = (a,b) -> System.out.println(" Multiplication output is " + a*b);
	private BiConsumer<Integer, Integer> addition = (a,b) -> System.out.println(" Addition output is" + a+b);
	private BiConsumer<String, List<String>> printNameAndAcitivities = (nm,act) -> System.out.println(" Student Name =" + nm + " and activities =" + act );
	public static void main(String[] args) {
		LambdaBiConsumerExamples lBiCon = new LambdaBiConsumerExamples();
		lBiCon.multiply.andThen(lBiCon.addition).accept(10, 20);
		lBiCon.printStudentNamesAndActivities(StudentDataBase.getAllStudents());
	}
	
	public void printStudentNamesAndActivities(List<Student> students) {
		System.out.println("Printing student names and activities ");
		students.forEach((stu) -> {printNameAndAcitivities.accept(stu.getName(), stu.getActivityList());});
	}
}
