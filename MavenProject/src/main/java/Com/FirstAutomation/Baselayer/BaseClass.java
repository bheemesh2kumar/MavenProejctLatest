package Com.FirstAutomation.Baselayer;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Com.FirstAutomation.Pages.ZooplaLoginpage;
import Com.FirstAutomation.Utilities.BrowserFactory;
import Com.FirstAutomation.Utilities.ReadConfigUtility;

public class BaseClass {

	ZooplaLoginpage ZooplaLoginpageref;

	public WebDriver driver;

	public static Logger logger;
	ReadConfigUtility ReadConfigUtilityref;

	// this is before method will be executed before eeach test
	@BeforeMethod
	public void Setup() {
		ReadConfigUtilityref=new ReadConfigUtility();
		driver = BrowserFactory.StartApplication(driver,ReadConfigUtilityref.getApplicationurl() ,ReadConfigUtilityref.getBrowser());
		ZooplaLoginpageref = new ZooplaLoginpage(driver);
		ZooplaLoginpageref.Signinmainbutton.click();
		ZooplaLoginpageref.logintoApplication(ReadConfigUtilityref.getUserName(),ReadConfigUtilityref.getPassward());
		logger = Logger.getLogger("New Maven Project");
		PropertyConfigurator.configure("Log4j.properties");

	}

	// this is after method will be executed after each test
	@AfterMethod
	public void TearDown() {
		BrowserFactory.QuitBrowser(driver);
	}

}
