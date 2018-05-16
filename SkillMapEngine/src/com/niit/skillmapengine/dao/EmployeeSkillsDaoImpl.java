package com.niit.skillmapengine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.niit.skillmapengine.configuration.DbConfig;
import com.niit.skillmapengine.model.Employee;

public class EmployeeSkillsDaoImpl implements EmployeeSkillDao 
{
	Connection conn;	

	public EmployeeSkillsDaoImpl() 
	{
	  conn=DbConfig.getConnection(); 
	}

	@Override
	public Map<String,Double> searchMultiple(int[] skills) {
		
		Map<String,Double> mailds=new HashMap<String,Double>(1);
		
		try
		{
			
		PreparedStatement pst1=conn.prepareStatement("SELECT `EID` FROM `empskills` WHERE `SID` =?");
			
		double c=(double)100/(double)skills.length;
		for(int id:skills)
		{
			
			pst1.setInt(1,id);
			ResultSet rs=pst1.executeQuery();
			
			while(rs.next())
			{	
				if(mailds.get(rs.getString("EID"))==null)
				{
					
					mailds.put(rs.getString("EID"),c) ;
				}
				else
				{
				    mailds.put(rs.getString("EID"),(mailds.get(rs.getString("EID"))+c)) ;
				}				
			}
		}
		
		
		}
		catch(Exception ex)
		{
			
			System.out.println("Exception Occured :"+ex.getMessage());			
			
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		//System.out.println("Employees with no of Matched Technologies"+mailds);
		return mailds;
	}

	
}
