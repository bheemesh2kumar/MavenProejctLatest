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

	ZooplaHomepage ZooplaHomepageref;

	@Test
	public void logintoapp() {

		ZooplaHomepageref = new ZooplaHomepage(driver);
		logger.info("Created object for home page");
		logger.info("getting page title");

		String titl = driver.getTitle();
		System.out.println(titl);
		Assert.assertEquals("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents", titl);
		logger.info("test is pass resutls are matched");
		String userprofilename = ZooplaHomepageref.UserProfilename.getText();
		System.out.println(userprofilename);

	}

}
