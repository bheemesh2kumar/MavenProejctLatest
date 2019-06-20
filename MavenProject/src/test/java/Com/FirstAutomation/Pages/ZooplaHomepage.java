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

public class ZooplaHomepage extends HomebasedMethods

{
	private static final String HttpURLConnection = null;
	WebDriver driver;

	public ZooplaHomepage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//a")
	public List<WebElement> alllinks;

	

}
