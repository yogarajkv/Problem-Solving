package com.garding.pojo;

import com.grading.core.GradeAllocation;

public class Teacher {
	
	private  final String teacherName;
	
	private GradeAllocation allocation;	
	
	
	public String getTeacherName() {
		return teacherName;
	}
	
	public GradeAllocation getAllocation() {
		return allocation;
	}

	public void setAllocation(GradeAllocation allocation) {
		this.allocation = allocation;
	}

	public Teacher( final String teacherName)
	{
		this.teacherName = teacherName;
	}
	public Teacher(final String teacherName, final GradeAllocation allocation)
	{
		this.teacherName = teacherName;
		this.allocation = allocation;
	}

}
