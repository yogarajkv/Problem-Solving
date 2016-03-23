package com.grading.core;

import java.util.ArrayList;
import java.util.List;

import com.garding.exception.GradeException;
import com.garding.pojo.AssessmentType;

public class GradeAllocation {

	private static class Percentage {
		 AssessmentType type;
		 double percentage;

		Percentage(AssessmentType type, double percentage) {
			this.type = type;
			this.percentage = percentage;
		}
	}

	private final List<Percentage> percentageList;

	public GradeAllocation() {
		percentageList = new ArrayList<>();
	}

	public void allocate(AssessmentType type, double percentage)
	{
		Percentage p = new Percentage(type, percentage);
		percentageList.add(p);
	}
	
	public double getAllocatedPercentage(AssessmentType type) throws GradeException
	{
		if (percentageList.isEmpty())
			throw new GradeException("Percentage allocation is not happen. ");
		
		for(Percentage p:percentageList)
		{
			if (p.type.equals(type))
			{
				return p.percentage;
			}
		}
		return 0.0;
	}
	

}
