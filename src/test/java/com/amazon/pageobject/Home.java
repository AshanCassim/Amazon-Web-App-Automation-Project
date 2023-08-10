package com.amazon.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


	
/***********************************************
* Author    :   Ashan Cassim
* Date      :   2021-04-05
* Desc      :   Reward Engine Project Test Automation  
* Status    :   Test
************************************************/

public class Home  {
	
	public WebDriver ldriver;

	public Home(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	

	@FindBy(how = How.XPATH, using = "//*[@id='searchDropdownBox']")
	@CacheLookup
	WebElement DropdwnALL;
			
	@FindBy(how = How.XPATH, using = "//*[@id='twotabsearchtextbox']")
	WebElement searchbar;
	
	@FindBy(how = How.XPATH, using = "//*[@id='nav-search-submit-button']")
	WebElement searchbtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='p_72/1250222011']/span/a/section/i")
	WebElement rating;
	
	@FindBy(how = How.XPATH, using = "//*[@id='p_n_feature_nine_browse-bin/3291437011']/span/a/div/label/i")
	WebElement language;   
	
	@FindBy(how = How.XPATH, using = "//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")
	WebElement soconditm; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='price']")
	WebElement unitprice; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='productTitle']")
	WebElement pname;
	
	@FindBy(how = How.XPATH, using = "//*[@id='a-autoid-0-announce']")
	WebElement quantity; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='quantity_1']")
	WebElement qtty2;
	
	@FindBy(how = How.XPATH, using = "//*[@id='add-to-cart-button']")
	WebElement addcart;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"sw-gtc\"]/span/a")
	WebElement gocart;
	
	@FindBy(how = How.XPATH, using = "//*[@id='sc-active-a0d49023-0618-41d5-89a4-74ea87fde69d']/div[4]/div/div[2]/ul/li[1]/span/a/span[1]/span/span[2]")
	WebElement addedbook;            
	
	@FindBy(how = How.XPATH, using = "//*[@id='sc-subtotal-amount-buybox']/span")
	WebElement finaltotal;
	
	@FindBy(how = How.XPATH, using = "//*[@id='sc-active-a0d49023-0618-41d5-89a4-74ea87fde69d']/div[4]/div/div[2]/div[1]/span[2]/span/input")
	WebElement deleteitem; 
	
	@FindBy(how = How.XPATH, using = "//*[@id='sc-subtotal-amount-activecart']/span ")
	WebElement amount;
	
	public void selectOption(String Option) throws InterruptedException {
		
		Select se = new Select(DropdwnALL);
		se.selectByVisibleText(Option);
	}
	
	public void search(String SearchTXT) throws InterruptedException {
		
		searchbar.sendKeys(SearchTXT);
		searchbtn.click();
		Thread.sleep(5000);
	}
	
	public void selectrating() throws InterruptedException {
		
		//scrolltoele (rating);
		rating.click();
	}
	
	public void selectLang() throws InterruptedException {
		
		scrolltoele (language);
		language.click();
	}
	
	public String getname() throws InterruptedException {
		
		String name = soconditm.getText();
		return name;
	}
	
	public void nevigatetoitem() throws InterruptedException {
		
		soconditm.click();
		
	}
	
	public String getprice() throws InterruptedException {
		
		String price = unitprice.getText();
		return price;
	}
	
	public String getitemname() throws InterruptedException {
		
		String name = pname.getText();
		return name;
	}
	
	public void selectQuantity() throws InterruptedException {
		
		//Select sq = new Select(DropdwnALL);
		
		//sq.selectByVisibleText(Option);
	
			ldriver.navigate().refresh();
			DropdwnALL.click();
			qtty2.click();
	}
	
	public void addcart() throws InterruptedException {
	
			addcart.click();
	}
	
	public void gotocart() throws InterruptedException {
		
			gocart.click();
	}
	
	public String addedname() throws InterruptedException {
		
		String name = addedbook.getText();
		return name;
	}
	
	public String fianalprice() throws InterruptedException {
		
		String total = finaltotal.getText();
		return total;
	}
	
	public void itemclear() throws InterruptedException {
		
		deleteitem.click();
	}
	
	public String amount() throws InterruptedException {
		
		String fprice = amount.getText();
		return fprice;
	}
	
    public void scrolltoele (WebElement ele) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		//This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", ele);
		
	}
	
	
	public int rows(WebElement mytable) throws InterruptedException {
		int rows_count=0;
		try {
			
			
	    	//To locate rows of table. 
	    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
	    	//To calculate no of rows In table.
	    	rows_count = rows_table.size(); 
	    	//System.out.println( "rows_count " + rows_count);
			
			
		} catch (Exception e) {
			System.out.println( e.toString());
		}
		
		return rows_count;
	}

	public ArrayList<String> General_Information_Status() throws InterruptedException {
		 
		ArrayList<String> alist=new ArrayList<String>(); 
		
		
		try {
			
			WebElement mytable1 = ldriver.findElement(By.xpath("//*[@id=\"ajax\"]/table[1]/tbody"));
	    	int rows_count = rows(mytable1); //*[@id="ajax"]/table[1]/tbody/tr[10]/td[4]/span/b
	    	System.out.println( "rows_count " + rows_count);
	    	 
	    	String val1;
	    	int i = rows_count-1;
	    	
	    		//System.out.println("Hi raw");
	    		for(int k=1 ; k<=4 ; k++){
	    			
	    			//System.out.println("Hi col");
    				val1 = ldriver.findElement(By.xpath("//*[@id=\"ajax\"]/table[1]/tbody/tr["+i+"]/td["+k+"]")).getText();
    				
		    		System.out.println(val1);
		    		System.out.print(" ");
		    		alist.add(val1);
    			
	    		}
	    		
	    	
	    	//String val1 = ldriver.findElement(By.xpath("//*[@id='ajax']/table[2]/tbody/tr["+ rows_count+"]/td")).getText();
	    												
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return alist;
	}


}
