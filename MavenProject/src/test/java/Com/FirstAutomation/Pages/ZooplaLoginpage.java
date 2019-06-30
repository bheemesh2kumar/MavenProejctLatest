package Com.FirstAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZooplaLoginpage extends HomebasedMethods {

	public WebDriver driver;

	public ZooplaLoginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	//this is sign web element
	@FindBy(xpath = "//a[@class='button button--tertiary-dark account-link__text']")
	public WebElement Signinmainbutton;

	@FindBy(xpath = "//input[@id='signin_email']")
	public WebElement EmailText;

	@FindBy(xpath = "//input[@id='signin_password']")
	public WebElement PasswordText;

	@FindBy(xpath = "//button[@name='action:signin']")
	public WebElement Loginbutton;
	
	
	
	
	
	//page login
	
	
	public void logintoApplication(String username,String password)
	{
		EmailText.sendKeys(username);
		PasswordText.sendKeys(password);
		Loginbutton.click();
		
	}
	

}
