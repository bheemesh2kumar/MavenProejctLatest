package Com.FirstAutomation.Baselayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Com.FirstAutomation.Pages.ZooplaLoginpage;
import Com.FirstAutomation.Utilities.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;
	
	//this  is before method will be executed before eeach test 
	@BeforeMethod
	public void Setup()
	{
		driver=BrowserFactory.StartApplication(driver, "https://www.zoopla.co.uk/?signedin=1", "Chorome");
		 
		
	
	}
	
	//this is after method will be executed after each test
	@AfterMethod
	public void TearDown()
	{
		BrowserFactory.QuitBrowser(driver);
	}
	
	
	
	
	

}
