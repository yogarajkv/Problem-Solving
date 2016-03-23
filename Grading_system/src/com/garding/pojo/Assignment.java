package com.garding.pojo;

public class Assignment {

	private final String assignmentName;
	private final AssessmentType type;
	
	private final double scored;
	
	public Assignment(final String name,final AssessmentType type, final double scored)
	{
		this.assignmentName = name;
		this.type = type;
		this.scored = scored;
	}
	
	public AssessmentType getAssignmentType() {
		return type;
	}

	public double getScore() {
		return scored;
	}

	public String getAssignmentName() {
		return assignmentName;
	}
}
