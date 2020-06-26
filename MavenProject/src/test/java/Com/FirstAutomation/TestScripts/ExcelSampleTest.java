package Com.FirstAutomation.TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.FirstAutomation.Baselayer.BaseClassExcelValidation;
import Com.FirstAutomation.Pages.ExcelSamplepageOR;
import Com.FirstAutomation.Utilities.CommonUtilities;
import net.lingala.zip4j.ZipFile;

public class ExcelSampleTest extends BaseClassExcelValidation

{

	ExcelSamplepageOR ExcelSamplepageORref;
	CommonUtilities CommonUtilitiesref;

	ArrayList<Map<String, Object>> exceldownlaodarrylistmap;

	@Test(priority = 1)
	public void downloadexcelvalidation() throws InterruptedException, IOException {
		ExcelSamplepageORref = new ExcelSamplepageOR(driver);

		// ExcelSamplepageORref.sampleexceldownloadbutton.click();
		CommonUtilitiesref = new CommonUtilities();
		CommonUtilitiesref.scrollintoView(driver, ExcelSamplepageORref.sampleexceldownloadbutton);
		ExcelSamplepageORref.sampleexceldownloadbutton.click();

		Thread.sleep(5000);

		String downlaodexcelpath = System.getProperty("user.dir") + "\\Exceldownloads\\";

		File excelfiles = new File(downlaodexcelpath);

		if (excelfiles.list().length > 0) {
			for (File exfiles : excelfiles.listFiles()) {
				exfiles.delete();
			}
		}

		String downlaodzippath = System.getProperty("user.dir") + "\\Zipfolder";

		File file = new File(downlaodzippath);

		File[] files = file.listFiles();

		ZipFile ZipFileref = new ZipFile(files[0]);

		ZipFileref.extractAll(downlaodexcelpath);

		System.out.println("excel file extracketed");

		// String downlaodexcelpath = System.getProperty("user.dir") +
		// "\\Exceldownloads\\";

		File fileto = new File(downlaodexcelpath);

		File[] filearry = fileto.listFiles();

		File excelfile = filearry[0];

		FileInputStream fis = new FileInputStream(excelfile);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("SalesOrders");

		int lastrownumber = sheet.getLastRowNum();

		exceldownlaodarrylistmap = new ArrayList<Map<String, Object>>();

		XSSFRow headerrow = sheet.getRow(0);

		for (int i = 1; i <= lastrownumber; i++) {

			HashMap<String, Object> hashmap = new HashMap<String, Object>();

			XSSFRow eachrow = sheet.getRow(i);

			int colscount = eachrow.getLastCellNum();

			for (int j = 0; j < colscount; j++) {

				hashmap.put(headerrow.getCell(j).toString(), eachrow.getCell(j).toString());

			}

			exceldownlaodarrylistmap.add(hashmap);

		}

		System.out.println("printing excel values");

		for (int excelrow = 0; excelrow < exceldownlaodarrylistmap.size(); excelrow++) {
			System.out.println(exceldownlaodarrylistmap.get(excelrow));
		}

	}

	@Test(priority = 2)
	public void donwlaodexcelrecords() {

		ExcelSamplepageORref = new ExcelSamplepageOR(driver);

		CommonUtilitiesref = new CommonUtilities();

		CommonUtilitiesref.scrollintoView(driver, ExcelSamplepageORref.sampleexceltable);

		ExcelSamplepageORref.getallrecordsasarraylist(ExcelSamplepageORref.sampleexceltable);

		for (int i = 0; i < ExcelSamplepageORref.totalmaprecords.size(); i++) {
			System.out.println(ExcelSamplepageORref.totalmaprecords.get(i));
		}
	}

	@Test(priority = 3)
	public void validatetwoarrylistmaps() {

		ExcelSamplepageORref = new ExcelSamplepageOR(driver);

		CommonUtilitiesref = new CommonUtilities();

		if (ExcelSamplepageORref.totalmaprecords.equals(exceldownlaodarrylistmap)) {
			System.out.println("Excel online records are matched with Excel downlaod records successfully");
		}

		else {
			System.out.println("Records are not matched");
			Assert.assertTrue(false);
		}

	}

}
