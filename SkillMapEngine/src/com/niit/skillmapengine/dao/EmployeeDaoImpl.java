package com.niit.skillmapengine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.niit.skillmapengine.configuration.DbConfig;
import com.niit.skillmapengine.exceptions.ValidationException;
import com.niit.skillmapengine.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao
{
	Connection conn;
	private Pattern regexPattern;
    private Matcher regMatcher;
	

	public EmployeeDaoImpl()
	{

		this.conn = DbConfig.getConnection();
	}

	@Override
	public boolean deleteEmployee(Employee e) {
		try
		{
		Statement st=conn.createStatement();
		String str="DELETE FROM `skillmapengine`.`employee` WHERE `employee`.`MAILID` = '"+e.getMailid()+"'";
		int rs=st.executeUpdate(str);
		str="DELETE FROM `skillmapengine`.`empskills` WHERE `empskills`.`EID` = '"+e.getMailid()+"'";
		st.executeUpdate(str);
		return true;
		}
		catch(Exception ex)
		{
			System.out.println("Exception Occured :"+ex.getMessage());
			return false;
			
		}
		finally
		{

			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean updateEmployee(Employee e) {
		try
		{
		Statement st=conn.createStatement();
		String str="UPDATE  `skillmapengine`.`employee` SET  `PASSWORD` =  '"+e.getPassword()+"',`NAME` =  '"+e.getName()+"',`MOBILE` =  '"+e.getMobile()+"',`CENTRECODE` =  '"+e.getCentreCode()+"',`SUPERVISOR` =  '"+e.getSupervisor()+"',`STATUS` =  '"+e.getStatus()+"',`QUALIFICATION` =  '"+e.getQualification()+"',`NOOFVISIT` =  '"+e.getNofvisit()+"',`YOP` =  '"+e.getYop()+"',`EXPERIENCE` =  '"+e.getExperience()+"',`REMARK` =  '"+e.getRemark()+"',`ROLE` =  '"+e.getRole()+"' WHERE  `employee`.`MAILID` =  '"+e.getMailid()+"'";
		int rs=st.executeUpdate(str);
		return true;
		}
		catch(Exception ex)
		{
		
			System.out.println("Exception Occured :"+ex.getMessage());
			return false;
			
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

	@Override
	public Employee getEmployeebyId(String mailId)
	{
		Employee e=null;
		try
		{
		Statement st=conn.createStatement();
		String str="SELECT * FROM `employee` WHERE `MAILID` = '"+mailId+"'";
		ResultSet rs=st.executeQuery(str);
		rs.next();
	    e=new Employee();
	    e.setMailid(rs.getString("MAILID"));
	    e.setPassword(rs.getString("PASSWORD"));
	    e.setName(rs.getString("NAME"));
	    e.setMobile(rs.getString("MOBILE"));
	    e.setCentreCode(rs.getInt("CENTRECODE"));
	    e.setExperience(rs.getInt("EXPERIENCE"));  
	    e.setNofvisit(rs.getInt("NOOFVISIT"));
	    e.setQualification(rs.getString("QUALIFICATION"));
	    e.setRemark(rs.getString("REMARK"));
	    e.setRole(rs.getString("ROLE"));
	    e.setStatus(rs.getString("STATUS"));
		return e;
		}
		catch(Exception ex)
		{
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Exception Occured :"+ex.getMessage());
			return e;
			
		}
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> list=new ArrayList<>();
		Employee e;
		try
		{
		Statement st=conn.createStatement();
		String str="SELECT * FROM `employee`";
		ResultSet rs=st.executeQuery(str);
		while(rs.next())
		{
	    e=new Employee();
	    e.setMailid(rs.getString("MAILID"));
	    e.setPassword(rs.getString("PASSWORD"));
	    e.setName(rs.getString("NAME"));
	    e.setMobile(rs.getString("MOBILE"));
	    e.setCentreCode(rs.getInt("CENTRECODE"));
	    e.setExperience(rs.getInt("EXPERIENCE"));  
	    e.setNofvisit(rs.getInt("NOOFVISIT"));
	    e.setQualification(rs.getString("QUALIFICATION"));
	    e.setRemark(rs.getString("REMARK"));
	    e.setRole(rs.getString("ROLE"));
	    e.setStatus(rs.getString("STATUS"));
	    list.add(e);
		}
		return list;
		}
		catch(Exception ex)
		{
			System.out.println("Exception Occured :"+ex.getMessage());
			return list;			
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public boolean validate(String mailid, String password) {
		
		try
		{
		Statement st=conn.createStatement();
		String str="SELECT * FROM `employee` WHERE `MAILID`= '"+mailid+"' and `PASSWORD`='"+password+"'";
		ResultSet rs=st.executeQuery(str);
		if(rs.next())
		{
			System.out.println("\nValid User name--------------"+rs.getString("NAME"));
			return true;
		}
		else
		{
			System.out.println("\nInValid User name--------------");
			return false;
		}
		
	   
		}
		catch(Exception ex)
		{
			System.out.println("Exception Occured :"+ex.getMessage());
			return false;
			
		}
		finally
		{

			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public boolean saveEmployee(Employee e,int[] sids) throws ValidationException 
	{

	
	if(validateEmail(e.getMailid())&&validateMobile(e.getMobile())&&validatePassword(e.getPassword()))
	{		
	try
	{
	conn.setAutoCommit(false);
	Statement st=conn.createStatement();
	String str="INSERT INTO `skillmapengine`.`employee` (`MAILID`, `PASSWORD`, `NAME`, `MOBILE`, `CENTRECODE`, `SUPERVISOR`, `STATUS`, `QUALIFICATION`, `NOOFVISIT`, `YOP`, `EXPERIENCE`, `REMARK`, `ROLE`) VALUES ('"+e.getMailid()+"', '"+e.getPassword()+"', '"+e.getName()+"', '"+e.getMobile()+"', '"+e.getCentreCode()+"', '"+e.getSupervisor()+"', 'P', '"+e.getQualification()+"', '0', '"+e.getYop()+"', '"+e.getExperience()+"', '', '"+e.getRole()+"')";
	int rs=st.executeUpdate(str);
	PreparedStatement pst=conn.prepareStatement("INSERT INTO `skillmapengine`.`empskills` (`EID`, `SID`) VALUES (?, ?)");
		for(int id:sids)
		{
			pst.setString(1, e.getMailid());
			pst.setInt(2, id);
			rs=pst.executeUpdate();
	   
		}	
	conn.commit();
	return true;
	}
	catch(Exception ex)
	{
		System.out.println("Exception Occured :"+ex.getMessage());
		return false;
		
	}
	finally
	{		
		try 
		{
			conn.rollback();
			conn.close();
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
	 }
    }
		else
		{
			return false;
		}
	}
	
	public boolean validateEmail(String mailid) throws ValidationException
	{
		 regexPattern = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");
	     regMatcher   = regexPattern.matcher(mailid);
	     if(regMatcher.matches())
	     {
	            return true;
	     } 
	     else 
	     {
	            throw new ValidationException("Invalid MailId");
	     }	
	}
	public boolean validatePassword(String password) throws ValidationException
	{ 
		regexPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
		/*
		 *
		 * ^                 # start-of-string
		 (?=.*[0-9])       # a digit must occur at least once
		 (?=.*[a-z])       # a lower case letter must occur at least once
		 (?=.*[A-Z])       # an upper case letter must occur at least once
		 (?=.*[@#$%^&+=])  # a special character must occur at least once
		 (?=\S+$)          # no whitespace allowed in the entire string
		 .{8,}             # anything, at least eight places though
		 $                 # end-of-string
		 */
        regMatcher   = regexPattern.matcher(password);
       if(regMatcher.matches()) 
       {
              return true;
       } 
       else
       {
             throw new ValidationException("Invalid Password");
       }	
		
	}
	public boolean validateMobile(String mobile) throws ValidationException
	{
		regexPattern = Pattern.compile("^[987][0-9]{9}$");
        regMatcher   = regexPattern.matcher(mobile);
       if(regMatcher.matches()) 
       {
              return true;
       } 
       else
       {
    	   throw new ValidationException("Invalid Mobile Number");
       }	
	}

}
