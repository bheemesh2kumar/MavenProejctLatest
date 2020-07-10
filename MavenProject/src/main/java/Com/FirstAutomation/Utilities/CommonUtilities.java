package Com.FirstAutomation.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtilities {

	public void clickusingjs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click;", element);
	}

	public void scrollintoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void mouseoverlement(WebDriver driver, WebElement element) {

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();

	}

}
