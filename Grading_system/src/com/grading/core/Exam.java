package com.grading.core;

import java.util.ArrayList;
import java.util.List;

import com.garding.pojo.AssessmentType;
import com.garding.pojo.Assignment;

public class Exam {

	private final String name;

	private final List<Assignment> assignments;

	private double weightedAverage;

	public Exam(String name) {
		this.name = name;
		assignments = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	
	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void addAssignment(String assignmentName, AssessmentType type, double score) {
		assignments.add(new Assignment(assignmentName,type, score));
	}

	public double getWeightedAverage() {
		return weightedAverage;
	}

	public void setWeightedAverage(double weightedAverage) {
		this.weightedAverage = weightedAverage;
	}

}
