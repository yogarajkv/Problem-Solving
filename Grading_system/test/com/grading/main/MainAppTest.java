package com.grading.main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.garding.pojo.AssessmentType;
import com.garding.pojo.Student;
import com.garding.pojo.Teacher;
import com.grading.core.Exam;
import com.grading.core.GradeAllocation;

public class MainAppTest {

	
	 private MainApp app;
	 
	 @Before
	 public void beforeSetup()
	 {
		 app = new MainApp();
	 }
	
	
	@Test
	public void run()
	{			
		Teacher staff1 = new Teacher("Tom Teacherman ");
		GradeAllocation allocation = new GradeAllocation();
		allocation.allocate(AssessmentType.ASSIGNMENT, 10.1);
		allocation.allocate(AssessmentType.EXAM, 89.9);
		allocation.allocate(AssessmentType.EXTRA_CREDIT_ASSIGNMENT, 2);
		staff1.setAllocation(allocation);
		
		List<Student> studentList = new ArrayList<>();
		
		
		Student student1 = new Student("Salley", 1);
		Exam exam = new Exam("Sample Exam");
		exam.addAssignment("Assignment 1", AssessmentType.ASSIGNMENT, 85);
		exam.addAssignment("Assignment 2", AssessmentType.ASSIGNMENT, 88);
		exam.addAssignment("Extra Credit Assignment", AssessmentType.EXTRA_CREDIT_ASSIGNMENT, 0.0);
		exam.addAssignment("Assignment 3", AssessmentType.ASSIGNMENT, 92);
		exam.addAssignment("Exam 1", AssessmentType.EXAM, 91);
		student1.setStaff(staff1);
		student1.setExam(exam);
		
		studentList.add(student1);
		app.calculateScore(studentList);
	}
	
	@Test
	public void calculateScoreWithoutAllocation()
	{			
		Teacher staff1 = new Teacher("Tom Teacherman ");
		GradeAllocation allocation = new GradeAllocation();
		allocation.allocate(AssessmentType.ASSIGNMENT, 10.1);
		//allocation.allocate(AssessmentType.EXAM, 89.9);
		allocation.allocate(AssessmentType.EXTRA_CREDIT_ASSIGNMENT, 2);
		staff1.setAllocation(allocation);
		
		List<Student> studentList = new ArrayList<>();
		
		
		Student student1 = new Student("Salley", 1);
		Exam exam = new Exam("Sample Exam");
		exam.addAssignment("Assignment 1", AssessmentType.ASSIGNMENT, 85);
		exam.addAssignment("Assignment 2", AssessmentType.ASSIGNMENT, 88);
		exam.addAssignment("Extra Credit Assignment", AssessmentType.EXTRA_CREDIT_ASSIGNMENT, 0.0);
		exam.addAssignment("Assignment 3", AssessmentType.ASSIGNMENT, 92);
		exam.addAssignment("Exam 1", AssessmentType.EXAM, 91);
		student1.setStaff(staff1);
		student1.setExam(exam);
		
		studentList.add(student1);
		app.calculateScore(studentList);
	}
	
	@Test
	public void calculateScoreWithoutExam()
	{			
		Teacher staff1 = new Teacher("Tom Teacherman ");
		GradeAllocation allocation = new GradeAllocation();
		allocation.allocate(AssessmentType.ASSIGNMENT, 10.1);
		allocation.allocate(AssessmentType.EXAM, 89.9);
		allocation.allocate(AssessmentType.EXTRA_CREDIT_ASSIGNMENT, 2);
		staff1.setAllocation(allocation);
		
		List<Student> studentList = new ArrayList<>();
		
		
		Student student1 = new Student("Salley", 1);
		Exam exam = new Exam("Sample Exam");
		exam.addAssignment("Assignment 1", AssessmentType.ASSIGNMENT, 85);
		exam.addAssignment("Assignment 2", AssessmentType.ASSIGNMENT, 88);
		exam.addAssignment("Extra Credit Assignment", AssessmentType.EXTRA_CREDIT_ASSIGNMENT, 0.0);
		exam.addAssignment("Assignment 3", AssessmentType.ASSIGNMENT, 92);
		//exam.addAssignment("Exam 1", AssessmentType.EXAM, 91);
		student1.setStaff(staff1);
		student1.setExam(exam);
		
		studentList.add(student1);
		app.calculateScore(studentList);
	}
}
