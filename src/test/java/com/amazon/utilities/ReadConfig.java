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

public class ReadConfig {
	
	Properties configPropObj;
	
	public ReadConfig() 
	{
		// Load config.properties file
		
		File file = new File("./Configuration/config.properties");
		
		try {
			configPropObj = new Properties();
			
			FileInputStream configfile = new FileInputStream(file);
			configPropObj.load(configfile);
			// end of loading gconfig.properties file
			
		} catch (IOException e) {
			
			System.out.println("Exception is: " + e.getMessage());
		}
		
	}
	
	public String getLiveAPI() 
	{
		String LiveAPI = configPropObj.getProperty("LiveAPI");
		return LiveAPI;
		
	}
	
	public String getLiveURI() 
	{
		String LiveURI = configPropObj.getProperty("LiveURI");
		return LiveURI;
		
	}
	
	public String getpara() 
	{
		String para = configPropObj.getProperty("para");
		return para;
		
	}
	
	public String getmsisdn() 
	{
		String msisdn = configPropObj.getProperty("msisdn");
		return msisdn;
		
	}
	
	public String getcardSerialId() 
	{
		String cardSerialId = configPropObj.getProperty("cardSerialId");
		return cardSerialId;
		
	}
	
	public String getcardProductId() 
	{
		String cardProductId = configPropObj.getProperty("cardProductId");
		return cardProductId;
		
	}
	
	public String getdrc() 
	{
		String drc = configPropObj.getProperty("drc");
		return drc;
		
	}
	
	public String getmanualRequest() 
	{
		String manualRequest = configPropObj.getProperty("manualRequest");
		return manualRequest;
		
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
	
	public String gethost() 
	{
		String host = configPropObj.getProperty("host");
		return host;
		
	}
	
	public String getuser() 
	{
		String user = configPropObj.getProperty("user");
		return user;
		
	}
	
	public String getpassword() 
	{
		String password = configPropObj.getProperty("password");
		return password;
		
	}
	public String getcommand1() 
	{
		String command1 = configPropObj.getProperty("command1");
		return command1;
		
	}
	
}
	
	


