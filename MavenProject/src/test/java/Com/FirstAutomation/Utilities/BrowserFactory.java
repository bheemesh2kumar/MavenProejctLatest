package Com.FirstAutomation.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public WebDriver driver;
	
	

	public static WebDriver StartApplication(WebDriver driver, String url, String browser) {

		if (browser.equalsIgnoreCase("Chorome")) {

			System.setProperty("webdriver.chrome.driver",
					"C:/Users/home/git/MavenProejctLatest/MavenProject/Drivers/chromedriver.exe");

			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("FireFox")) {

			System.setProperty("webdriver.firefox.driver", "C:/Users/home/workspace/MavenProject/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		}
		
		
		else 
		{
			
			System.out.println("Browser not supported");
		}
		
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return driver;

	}
	
	
	public static void QuitBrowser(WebDriver driver)
	{
	driver.quit();
	}
	
	
	
	
	

}
