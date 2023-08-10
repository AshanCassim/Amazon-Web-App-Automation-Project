package com.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/***********************************************
* Author    :   Ashan Cassim
* Date      :   2021-04-02
* Desc      :   Reward Engine Project Test Automation  
* Status    :   Test
************************************************/

public class ReadConfigLogin {
	
	Properties configPropObj;
	
	public ReadConfigLogin() 
	{
		// Load config.properties file
		
		File file = new File("./Configuration/configLogin.properties");
		
		try {
			configPropObj = new Properties();
			
			FileInputStream configfile = new FileInputStream(file);
			configPropObj.load(configfile);
			// end of loading gconfig.properties file
			
		} catch (IOException e) {
			
			System.out.println("Exception is: " + e.getMessage());
		}
		
	}
	
	public String getbaseURL() 
	{
		String baseURL = configPropObj.getProperty("baseURL");
		return baseURL;
		
	}
	
	public String getuname() 
	{
		String uname = configPropObj.getProperty("uname");
		return uname;
		
	}
	
	public String getpwd() 
	{
		String pwd = configPropObj.getProperty("pwd");
		return pwd;
		
	}
	
	public String getquteurl() 
	{
		String quteurl = configPropObj.getProperty("quteurl");
		return quteurl;
		
	}
	
}
	
	


