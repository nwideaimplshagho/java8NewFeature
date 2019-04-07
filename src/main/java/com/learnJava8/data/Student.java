package com.learnJava8.data;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;
	private int gradeLevel;
	private double gpa;
	private String gender;
	private List<String> activityList = new ArrayList<String>(1);

	public Student(String name, int gradeLevel, double gpa, String gender, List<String> activityList) {
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.activityList = activityList;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<String> activityList) {
		this.activityList = activityList;
	}
	
	public void printListOfActivities(){
        System.out.println("List of Activities are : " + this.activityList);
    }
	
	@Override
	public String toString() {
		return "Student{" +
                "name='" + name + '\'' +
                ", gradeLevel=" + gradeLevel +
                ", gpa=" + gpa +
                ", gender='" + gender + '\'' +
                ", activities=" + activityList +
                '}';
	}

}
