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

public class ZooplaHomepage extends HomebasedMethods

{
	private static final String HttpURLConnection = null;
      public WebDriver driver;

	public ZooplaHomepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//a")
	public List<WebElement> alllinks;
	
	@FindBy(xpath="//div[@class='subnav subnav--account']/p")
	public WebElement UserProfilename ;

	

}
