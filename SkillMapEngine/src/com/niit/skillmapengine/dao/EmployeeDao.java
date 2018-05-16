package com.niit.skillmapengine.dao;

import java.util.List;

import com.niit.skillmapengine.exceptions.ValidationException;
import com.niit.skillmapengine.model.Employee;
public interface EmployeeDao 
{
	boolean saveEmployee(Employee e,int[] sids) throws ValidationException;
	boolean deleteEmployee(Employee e);
	boolean updateEmployee(Employee e);
	Employee getEmployeebyId(String mailId);
	List<Employee> getEmployees();
	boolean validate(String mailid, String password);

}
