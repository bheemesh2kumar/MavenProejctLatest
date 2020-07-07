package Com.FirstAutomation.TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.FirstAutomation.Baselayer.BaseClass;
import Com.FirstAutomation.Pages.ZooplaHomepage;
import Com.FirstAutomation.Pages.ZooplaLoginpage;
import Com.FirstAutomation.Utilities.BrowserFactory;

public class ZooplaTest extends BaseClass {

	// ZooplaHomepage ZooplaHomepageref;

	@Test(dataProvider = "logintestdata")
	public void getlogindata(Map<String, String> testdata) {

		System.out.println("***************");
		System.out.println(testdata.get("UserName") + " " + testdata.get("Password"));

	}

	@Test(priority = 1, enabled = false)
	public void logintoapp() {

		logger.info("Created object for home page");
		logger.info("getting page title");

		String titl = driver.getTitle();
		System.out.println(titl);
		Assert.assertEquals("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents", titl);
		logger.info("test is pass resutls are matched");

	}

	@Test(priority = 2, enabled = false)
	public void validatesearchoptions() {

		// ZooplaHomepageref.forsaleoption.click();
		ZooplaHomepageref.torentoption.click();
		ZooplaHomepageref.housepricesoption.click();

	}

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

}
