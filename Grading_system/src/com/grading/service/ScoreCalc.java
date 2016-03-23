package com.grading.service;

import java.util.List;

import com.garding.exception.GradeException;
import com.garding.pojo.Assignment;
import com.grading.core.GradeAllocation;

public interface ScoreCalc {

	public double calculateScore (List<Assignment> assignmentList, GradeAllocation allocation) throws GradeException;
	
}
