package Com.FirstAutomation.TestScripts;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.FirstAutomation.Baselayer.BaseClass;
import Com.FirstAutomation.Pages.ZooplaHomepage;
import Com.FirstAutomation.Pages.ZooplaLoginpage;
import Com.FirstAutomation.Utilities.BrowserFactory;


public class LoginTest extends BaseClass {
	
	
	ZooplaLoginpage ZooplaLoginpageref;
	ZooplaHomepage ZooplaHomepageref;
	
	
	
	@Test
	public void logintoapp() 
	{
		
		ZooplaLoginpageref=new ZooplaLoginpage(driver);
				
		ZooplaLoginpageref.Signinmainbutton.click();
		
		ZooplaLoginpageref.logintoApplication("manu.bheemesh@gmail.com", "@Thoughts1");
		String titl=driver.getTitle();
		System.out.println(titl);
		Assert.assertEquals("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents", titl);
		
		//ZooplaHomepageref=new ZooplaHomepage();
		//ZooplaHomepageref.GetAlllinks(ZooplaHomepageref.alllinks);
		
		
		}
	
	
	
	
	
	

}
