package com.niit.skillmapengine.tests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.niit.skillmapengine.configuration.DbConfig;
import com.niit.skillmapengine.dao.EmployeeDao;
import com.niit.skillmapengine.dao.EmployeeDaoImpl;
import com.niit.skillmapengine.dao.EmployeeSkillDao;
import com.niit.skillmapengine.dao.EmployeeSkillsDaoImpl;
import com.niit.skillmapengine.exceptions.ValidationException;
import com.niit.skillmapengine.model.Employee;

public class EmployeeTestCase 
{
	Connection conn;
	
	EmployeeDao employeedao;
	EmployeeSkillDao employeeskilldao;

	@Before
	public void setUp() throws Exception 
	{
		employeedao=new EmployeeDaoImpl();
		employeeskilldao=new EmployeeSkillsDaoImpl();
	}

	@Test
	public void test()
	{
		assertNotEquals(null, DbConfig.getConnection());
		
	}
	@Test
	public void saveEmployee() throws ValidationException
	{
		Employee e=new Employee();
		e.setMailid("gayu3@gmail.com");
	    e.setPassword("1aA@aA@1");
	    e.setName("Harshitha");
	    e.setMobile("9876543210");
	    e.setCentreCode(34767);
	    e.setExperience(7);  
	    e.setNofvisit(0);
	    e.setQualification("BCA");
	    e.setSupervisor("UMesh");
	    e.setYop(2015);
	    e.setRemark("");
	    e.setRole("EMP");
	    e.setStatus("P");
		
	    int skills[]={2,1,5};
		
		assertEquals(true,employeedao.saveEmployee(e,skills));
		
	}
	@Test
	public void testMail() throws ValidationException
	{
		Employee e=new Employee();
		e.setMailid("gay u3@gmail.com");
	    e.setPassword("1aA@aA@1");
	    e.setName("Harshitha");
	    e.setMobile("9876543210");
	    e.setCentreCode(34767);
	    e.setExperience(7);  
	    e.setNofvisit(0);
	    e.setQualification("BCA");
	    e.setSupervisor("UMesh");
	    e.setYop(2015);
	    e.setRemark("");
	    e.setRole("EMP");
	    e.setStatus("P");
		
	    int skills[]={2,1,5};
		
		assertEquals(true,employeedao.saveEmployee(e,skills));
		
	}
	@Test
	public void testPassword() throws ValidationException
	{
		Employee e=new Employee();
		e.setMailid("gayu3@gmail.com");
	    e.setPassword("1aAa1");
	    e.setName("Harshitha");
	    e.setMobile("9876543210");
	    e.setCentreCode(34767);
	    e.setExperience(7);  
	    e.setNofvisit(0);
	    e.setQualification("BCA");
	    e.setSupervisor("UMesh");
	    e.setYop(2015);
	    e.setRemark("");
	    e.setRole("EMP");
	    e.setStatus("P");
		
	    int skills[]={2,1,5};
		
		assertEquals(true,employeedao.saveEmployee(e,skills));
		
	}
	@Test
	public void testMobile() throws ValidationException
	{
		Employee e=new Employee();
		e.setMailid("gayu3@gmail.com");
	    e.setPassword("1aA@#a12");
	    e.setName("Harshitha");
	    e.setMobile("987654");
	    e.setCentreCode(34767);
	    e.setExperience(7);  
	    e.setNofvisit(0);
	    e.setQualification("BCA");
	    e.setSupervisor("UMesh");
	    e.setYop(2015);
	    e.setRemark("");
	    e.setRole("EMP");
	    e.setStatus("P");
		
	    int skills[]={2,1,5};
		
		assertEquals(true,employeedao.saveEmployee(e,skills));
		
	}
	
	
	@Test
	public void deleteEmployee()
	{
		Employee e=new Employee();
		e.setMailid("5@gmail.com");			
		assertEquals(true,employeedao.deleteEmployee(e));
		
		
	}

	@Test
	public void updateEmployee()
	{
		Employee e=employeedao.getEmployeebyId("lovely@gmail.com");
		
		e.setName("Divya");
		e.setStatus("A");;
		
		assertEquals(true,employeedao.updateEmployee(e));
		
		
	}
	@Test
	public void getEmployee()
	{
		System.out.println("\nGet Employee\n===============\n"+employeedao.getEmployeebyId("harshitha@gmail.com"));
		
		
		
	}
	@Test
	public void getAllEmployees()
	{
		System.out.println("\nGet All Employees\n==========\n"+employeedao.getEmployees());
			
	}
	@Test
	public void validate()
	{
		
		assertTrue("Invalid Username or password",employeedao.validate("soumya@gmail.com", "123456"));
		
        		
	}
	

}
