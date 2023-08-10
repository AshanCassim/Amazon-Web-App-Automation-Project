# Amazon-Web-App-Automation-Project

Hybrid Framework For "Amazon" Web Application

*This is a test driven automation framework can be use to automate following fuctionality of Amazon e commerce site,

1 Navigation to official Amazon site (https://www.amazon.com/)
2.Select a category from the Category list
3.Search for the search term in search bar
4.Select Customer Reviews 
5.Select a Language
6.Get the name of the second item from the Product List page
7.Adding a prodaut to cart
8.Go to the cart and validating the product and clearing the list

To create this Framework I have used,

• TDD approach
• JDK Java OOP Concept
• Eclipse IDE
• TestNG plugin , maven-compiler-plugin & maven-surefire-plugin in Eclipse

• Maven Project Structure & Update pom.xml with below dependencies

 TestNG
 selenium-server
 webdriver manager
 extent reports
 log4j-core
 log4j-api
 fillo
 apache.poi
 poi-ooxml
 Junit

• And Folder Structure looks like below

 AmazonEcom
 Pageobjects(Packages)- store all the page objects
 testBase(Packages) - store all reuseable methods
 testCases(Packages)- store all the related test cases
 utilities(Packages)- Utility files like read from property files/ extent reports related classes
 Configurations(Folder) - all the property files are store in here
 Config.properties(File)
 Drivers(Folder)
 Reports(Folder)- reports are generated here
 Logs(Folder)- releated log files are store in here
 Screenshots(Folder)
 TestData(Folder)
 Pom.xml

To execute,
• Execute derectly test cases in com.amazon.testcases package or 
• using pom.xml, or
• Command prompt & run.bat file or
• testng.xml file

Issues found while framework building ,

org.openqa.selenium.StaleElementReferenceException is the most hard part to handle. To overcome that I have used following methods in my framework,

• Refreshing the web page
• Using Try Catch Block
• Using ExpectedConditions.refreshed

