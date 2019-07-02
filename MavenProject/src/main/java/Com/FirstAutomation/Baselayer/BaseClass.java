package Com.FirstAutomation.Baselayer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Com.FirstAutomation.Pages.ZooplaLoginpage;
import Com.FirstAutomation.Utilities.BrowserFactory;

public class BaseClass {

	ZooplaLoginpage ZooplaLoginpageref;

	public WebDriver driver;

	public static Logger logger;

	// this is before method will be executed before eeach test
	@BeforeMethod
	public void Setup() {
		driver = BrowserFactory.StartApplication(driver, "https://www.zoopla.co.uk/?signedin=1", "Chorome");
		ZooplaLoginpageref = new ZooplaLoginpage(driver);
		ZooplaLoginpageref.Signinmainbutton.click();
		ZooplaLoginpageref.logintoApplication("manu.bheemesh@gmail.com", "@Thoughts1");
		logger = Logger.getLogger("New Maven Project");
		PropertyConfigurator.configure("Log4j.properties");

	}

	// this is after method will be executed after each test
	@AfterMethod
	public void TearDown() {
		BrowserFactory.QuitBrowser(driver);
	}

}
