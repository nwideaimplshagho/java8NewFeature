package com.learnJava8.data;

public class Tution {

	private String name;
	private String tutor;

	public Tution(String name , String tutor) {
		this.name = name;
		this.tutor = tutor;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Tution [name=" + name + ", tutor=" + tutor + "]";
	}
}
