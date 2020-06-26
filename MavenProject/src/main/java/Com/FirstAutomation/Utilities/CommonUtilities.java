package Com.FirstAutomation.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonUtilities {
	 
	 
	 public void clickusingjs(WebDriver driver,WebElement element)
	 {
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click;", element);
	 }

	 
	 
	 public void scrollintoView(WebDriver driver,WebElement element)
	 {
		 JavascriptExecutor js =(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
	 } 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	

}
