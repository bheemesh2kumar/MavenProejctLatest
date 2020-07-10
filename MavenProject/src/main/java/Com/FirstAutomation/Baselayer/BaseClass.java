package Com.FirstAutomation.Baselayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import Com.FirstAutomation.Pages.ZooplaHomepage;
import Com.FirstAutomation.Pages.ZooplaLoginpage;
import Com.FirstAutomation.Utilities.BrowserFactory;
import Com.FirstAutomation.Utilities.CommonUtilities;
import Com.FirstAutomation.Utilities.ReadConfigUtility;

public class BaseClass {

	public ZooplaLoginpage ZooplaLoginpageref;
	public ZooplaHomepage ZooplaHomepageref;
	public CommonUtilities CommonUtilitiesref;

	public WebDriver driver;

	public static Logger logger;
	ReadConfigUtility ReadConfigUtilityref;

	// this is before method will be executed before eeach test

	@DataProvider(name = "logintestdata")
	public Object[][] providetestdata() throws IOException {

		String exceldatapath = System.getProperty("user.dir") + "\\TestDataExcel\\zooplalogintestdata.xlsx";

		File file = new File(exceldatapath);

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);

		int totrows = sheet.getLastRowNum();

		int totcols = sheet.getRow(0).getLastCellNum();

		Object objarry[][] = new Object[totrows][1];

		for (int i = 0; i < totrows; i++) {
			Map<String, String> mapdata = new HashMap<String, String>();

			for (int j = 0; j < totcols; j++) {

				mapdata.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());

			}

			objarry[i][0] = mapdata;

		}

		return objarry;

	}

	@BeforeMethod()
	public void Setup() throws InterruptedException {

		ReadConfigUtilityref = new ReadConfigUtility();
		CommonUtilitiesref = new CommonUtilities();
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
