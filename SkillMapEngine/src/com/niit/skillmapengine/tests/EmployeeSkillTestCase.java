package com.niit.skillmapengine.tests;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.niit.skillmapengine.configuration.DbConfig;
import com.niit.skillmapengine.dao.EmployeeSkillDao;
import com.niit.skillmapengine.dao.EmployeeSkillsDaoImpl;

public class EmployeeSkillTestCase {

    Connection conn;
	
	EmployeeSkillDao employeeskilldao;

	@Before
	public void setUp() throws Exception 
	{
		employeeskilldao=new EmployeeSkillsDaoImpl();
	}

	@Test
	public void test()
	{
		assertNotEquals(null, DbConfig.getConnection());
		
	}
	
	@Test
	public void searchMultiple()
	{
		int skills[]={1,2};
		System.out.println("\nEmployees after multiple skill search(java,spring,php)\n===========\n"+employeeskilldao.searchMultiple(skills));
		
	}

}
