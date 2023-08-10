package com.amazon.testcases;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.Test;
import com.amazon.base.BaseClass;
import com.amazon.pageobject.Home;


/***********************************************
* Author    :   Ashan Cassim
* Date      :   2023-08-10
* Desc      :   Amazon web Test Automation  
* Status    :   Test
************************************************/

public class TestCases extends BaseClass{
	
	public String responseBody1	;
	public String log	;
	
	@Test
	void Test() throws InterruptedException, IOException
	{
	
		logger.info("*********Started Test Case **********");
		
		node("Loging to Amazon ");
		
		setup();
		
		// To maximize the browser
	    driver.manage().window().maximize();
	    
		Home hp = new Home(driver);
		
		childTest.pass("Successfully navigate to : " + baseURL);
		Thread.sleep(3000);
		childTest.info("Selecting a option");
		hp.selectOption("Books");
		onTestPass("pass");
		Thread.sleep(3000);
		childTest.pass("Successfully Selected Book as  the option");
		
		childTest.info("Serch operation on progress");
		hp.search("Automation");
		onTestPass("pass");
		childTest.pass("Successfully Search for the Automation Book");
		
		childTest.info("rating operation on progress");
		hp.selectrating();
		onTestPass("pass");
		childTest.pass("Successfully selected the rating to 4");
		
		Thread.sleep(3000);
		
		childTest.info("Language selecting operation on progress");
		hp.selectLang();
		Thread.sleep(3000);
		onTestPass("pass");
		childTest.pass("Successfully selected English as a Language");
		
		Thread.sleep(3000);
		
		childTest.info("Getting name of the second item");
		String item = hp.getname();
		onTestPass("pass");
		childTest.pass("Successfully selected Second item name : "+ item);
		
		Thread.sleep(3000);
		
		childTest.info("nevigating to the second item");
		hp.nevigatetoitem();
		onTestPass("pass");
		childTest.pass("Successfully nevigated to the Second item");
	
		Thread.sleep(3000);
		
		childTest.info("Getting the unit price");
		String uprice = hp.getprice();
		onTestPass("pass");
		childTest.pass("Successfully got the unit price : "+ uprice);
		
		childTest.info("verifying name of the second item");
		String pitem = hp.getitemname();
		assertEquals(item, pitem);
		onTestPass("pass");
		childTest.pass("Successfully verified Second item name : "+ item);
		
		try {
			childTest.info("Selecting a Quantity");
			Thread.sleep(3000);
			hp.selectQuantity();
			onTestPass("pass");
		}
		catch(Exception e )
		{
			childTest.fail("Test failed : " + e.getMessage());
			//System.out.println(e.getMessage());
		}
		
		Thread.sleep(3000);
		
		childTest.info("adding to cart");
		hp.addcart();
		onTestPass("pass");
		childTest.pass("Successfully add to the cart");
		
		Thread.sleep(3000);
		
		childTest.info("go to cart");
		hp.gotocart();
		onTestPass("pass");
		childTest.pass("Successfully went to the cart");
		
		Thread.sleep(3000);
		
		childTest.info("verifying name of the second item");
		String addeditem = hp.addedname();
		assertEquals(pitem,addeditem );
		onTestPass("pass");
		childTest.pass("Successfully verified added item name : "+ item);
		
		childTest.info("verifying the total price");
		String total = hp.fianalprice();
		assertEquals(uprice,total );
		onTestPass("pass");
		childTest.pass("Successfully verified the total : "+ item);
		
		Thread.sleep(3000);
		
		childTest.info("clearing the cart");
		hp.itemclear();
		onTestPass("pass");
		childTest.pass("Successfully clear the cart");
		
		childTest.info("verifying the total price");
		String totalfinal = hp.amount();
		assertEquals("$0.00",totalfinal );
		onTestPass("pass");
		childTest.pass("Successfully verified the total : "+ item);
	}

}
