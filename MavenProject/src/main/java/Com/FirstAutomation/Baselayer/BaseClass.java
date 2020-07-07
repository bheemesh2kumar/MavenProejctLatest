package Com.FirstAutomation.Baselayer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Com.FirstAutomation.Pages.ZooplaHomepage;
import Com.FirstAutomation.Pages.ZooplaLoginpage;
import Com.FirstAutomation.Utilities.BrowserFactory;
import Com.FirstAutomation.Utilities.ReadConfigUtility;

public class BaseClass {

	public ZooplaLoginpage ZooplaLoginpageref;
	public ZooplaHomepage ZooplaHomepageref;

	public WebDriver driver;

	public static Logger logger;
	ReadConfigUtility ReadConfigUtilityref;

	// this is before method will be executed before eeach test
	@BeforeMethod()
	public void Setup() throws InterruptedException {

		ReadConfigUtilityref = new ReadConfigUtility();
		driver = BrowserFactory.StartApplication(driver, ReadConfigUtilityref.getApplicationurl(),
				ReadConfigUtilityref.getBrowser());
		ZooplaLoginpageref = new ZooplaLoginpage(driver);
		ZooplaHomepageref = new ZooplaHomepage(driver);

		// Thread.sleep(5000);

		ZooplaLoginpageref.Acceptallcookiesbutton.click();

		ZooplaLoginpageref.Signinmainbutton.click();

		/*
		 * try { ZooplaLoginpageref.Signinmainbutton.click(); } catch
		 * (WebDriverException ex) { ZooplaLoginpageref.Acceptallcookiesbutton.click();
		 * 
		 * ZooplaLoginpageref.Signinmainbutton.click();
		 * 
		 * }
		 */

		ZooplaLoginpageref.logintoApplication(ReadConfigUtilityref.getUserName(), ReadConfigUtilityref.getPassward());
		logger = Logger.getLogger("New Maven Project");
		PropertyConfigurator.configure("Log4j.properties");

	}

	// this is after method will be executed after each test
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
