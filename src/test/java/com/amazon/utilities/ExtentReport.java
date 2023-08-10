package com.amazon.utilities;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/***********************************************
* Author    :   Ashan Cassim
* Date      :   2021-04-02
* Desc      :   Reward Engine Project Test Automation  
* Status    :   Test
************************************************/

public class ExtentReport {
	
	ExtentSparkReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	
	@BeforeTest
	  public void report() 
	  {
		String DateName = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		htmlreporter = new ExtentSparkReporter("Reports/"+DateName+"@MyResult.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host name","ADL_localhost");
		extent.setSystemInfo("Environemnt","ADL_QA");
		extent.setSystemInfo("user","Ashan Cassim");
		
		htmlreporter.config().setDocumentTitle("Reward Engine Automation Report"); // Tile of report
		htmlreporter.config().setReportName("Reward Engine Testing"); // name of the report
		htmlreporter.config().setTheme(Theme.DARK);
	  } 
	
	@BeforeMethod
	  public void method(Method method) 
	  {
		parentTest =  extent.createTest(method.getName());
	  }
	
	
	  public void node(String action) 
	  {
		childTest = parentTest.createNode(action);
	  }
	  
	  
	
	
	

}
