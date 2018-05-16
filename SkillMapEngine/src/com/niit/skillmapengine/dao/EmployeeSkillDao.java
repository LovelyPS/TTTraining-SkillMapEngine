package com.niit.skillmapengine.dao;

import java.util.Map;


public interface EmployeeSkillDao
{
	Map<String,Double> searchMultiple(int[] skills);

}
