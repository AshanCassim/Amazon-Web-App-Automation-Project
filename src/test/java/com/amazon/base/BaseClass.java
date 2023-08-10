package com.amazon.base;

import java.io.IOException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.amazon.utilities.ExtentReport;
import com.amazon.utilities.ReadConfigLogin;
import com.aventstack.extentreports.MediaEntityBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/***********************************************
* Author    :   Ashan Cassim
* Date      :   2023-08-10
* Desc      :   Amazon web Test Automation  
* Status    :   Test
************************************************/

public class BaseClass extends ExtentReport{
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public WebDriver driver;
	
	ReadConfigLogin configObjLG = new ReadConfigLogin();
	
	public String baseURL = configObjLG.getbaseURL();
	public String quteurl = configObjLG.getquteurl();
	
	public Logger logger;
	
	@BeforeClass
	public void setuplog() throws IOException, InterruptedException
	{
		logger=Logger.getLogger("Amazon Test");//added Logger
		PropertyConfigurator.configure("Log4j.properties"); //added logger
		logger.setLevel(Level.DEBUG);
		
		
	}
	
	public void setup() throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.get(baseURL);
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		driver.quit();
		extent.flush();
	}
	

	public String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	public String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	public String screenShot() 
	{
		return ((TakesScreenshot) driver) .getScreenshotAs(OutputType.BASE64);
	}
	
	public void onTestFail(String condition) throws IOException 
	{
		childTest.fail(condition ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		
	}
	
	public void onTestPass(String condition) throws IOException 
	{
		childTest.pass(condition ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		
	}
	
	
	/*@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException, InterruptedException
	{
		if(br.equals("chrome"))
		{
			logger.info("********* starting TC on chrome*************");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
				
		}
		else if(br.equals("firefox"))
		{
			logger.info("********* starting TC on firefox*************");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			logger.info("********* starting TC on ie*************");
			//WebDriverManager.iedriver().setup();//Not working
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			Thread.sleep(3000);
		}
		else if(br.equals("edge"))
		{
			logger.info("********* starting TC on edge*************");
			WebDriverManager.edgedriver().setup(); //Not working
			//System.setProperty("webdriver.edge.driver","./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		Thread.sleep(5000);
		lp.logout();
		Thread.sleep(3000);
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	*/
	
	
}

