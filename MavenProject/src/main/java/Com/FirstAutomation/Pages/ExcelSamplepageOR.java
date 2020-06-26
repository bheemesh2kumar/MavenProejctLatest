package Com.FirstAutomation.Pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExcelSamplepageOR extends HomebasedMethods

{

	public WebDriver driver;

	public ExcelSamplepageOR(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='col-lg-8']//div[@class='well']//following-sibling::h2[1]//following-sibling::p/a[contains(text(),'Excel sample data workbook')]")
	public WebElement sampleexceldownloadbutton;

	@FindBy(xpath = "//div[@class='col-lg-8']/child::table")
	public WebElement sampleexceltable;

}
