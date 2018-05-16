package com.niit.skillmapengine.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConfig 
{
	public static Properties loadPropertiesFile()
	{

		Properties prop = new Properties();
		try(InputStream in= DbConfig.class.getResourceAsStream("db.properties"))
		{			
			prop.load(in);
		}
		catch (FileNotFoundException e)
		{
			 System.out.println("Exception Occured : "+e.getMessage());
		}
		catch (IOException e) 
		{
			System.out.println("Exception Occured : "+e.getMessage());
		}
		return prop;
	}
	public static Connection getConnection()
	{
		Connection conn = null;
		 
        try {
        	Properties prop = loadPropertiesFile();

			String driverClass = prop.getProperty("DB_DRIVER_CLASS");
			String url = prop.getProperty("DB_URL");
			String username = prop.getProperty("DB_USERNAME");
			String password = prop.getProperty("DB_PASSWORD");
			Class.forName(driverClass);

			conn = DriverManager.getConnection(url, username, password);
           
 
        } catch (SQLException ex)
        {
          System.out.println("Exception Occured : "+ex.getMessage());
        } catch (ClassNotFoundException e) {
        	 System.out.println("Exception Occured : "+e.getMessage());
		} 
       
        return conn;
	}

}
