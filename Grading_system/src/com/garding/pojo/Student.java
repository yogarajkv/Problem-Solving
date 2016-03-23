package com.garding.pojo;

import com.grading.core.Exam;

public class Student {

	private final String name;
	private final int rollNo;

	private Exam exam;
	
	private Teacher staff;

	public Student(final String name,final int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}

	public Student(String name, int rollNo, Exam exam) {
		this.name = name;
		this.rollNo = rollNo;
		this.exam = exam;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getName() {
		return name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public Teacher getStaff() {
		return staff;
	}

	public void setStaff(Teacher staff) {
		this.staff = staff;
	}

}
