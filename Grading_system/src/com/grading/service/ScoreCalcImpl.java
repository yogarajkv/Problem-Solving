package com.grading.service;

import java.util.List;

import com.garding.exception.GradeException;
import com.garding.pojo.AssessmentType;
import com.garding.pojo.Assignment;
import com.grading.core.GradeAllocation;

public class ScoreCalcImpl implements ScoreCalc {

	@Override
	public double calculateScore(List<Assignment> assignmentList, GradeAllocation allocation) throws GradeException {

		double weightedAverage = 0.0;
		double extraCredit = 0.0;
		double assignmentScore = 0.0;
		int assignmentCounter = 0;
		for (Assignment assignment : assignmentList) {

			switch (assignment.getAssignmentType()) {

			case ASSIGNMENT:
				assignmentScore = assignmentScore + assignment.getScore();
				System.out.println("After " + assignment.getAssignmentName() + " is logged in the system: "
						+ String.format("%5.2f", calculateAverage(assignmentScore, ++assignmentCounter, extraCredit)) + "%");
				break;
			case EXAM:
				weightedAverage = calculateAverage(assignmentScore, assignmentCounter, extraCredit)
						* allocation.getAllocatedPercentage(AssessmentType.ASSIGNMENT);
				if (allocation.getAllocatedPercentage(assignment.getAssignmentType()) != 0.0)
					weightedAverage += allocation.getAllocatedPercentage(assignment.getAssignmentType()) * assignment.getScore();
				else
					weightedAverage += assignment.getScore();
				weightedAverage = weightedAverage / 100;
				System.out.println("After " + assignment.getAssignmentName() + " is logged in the system: "
						+ String.format("%5.2f", weightedAverage) + "%");
				break;
			case EXTRA_CREDIT_ASSIGNMENT:
				extraCredit = allocation.getAllocatedPercentage(assignment.getAssignmentType());
				System.out.println("After " + assignment.getAssignmentName() + " is logged in the system: "
						+ String.format("%5.2f",calculateAverage(assignmentScore, assignmentCounter, extraCredit)) + "%");
				break;
			}
		}

		if (weightedAverage == 0.0)
			throw new GradeException("Assessment should nt consider, as the student not appered for exam");
		return weightedAverage;
	}

	private double calculateAverage(double score, double divider, double extraCredit) {
		return (score / divider) + extraCredit;
	}

}
