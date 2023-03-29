package Codesy.in.SwagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;		
	public LoginPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Initialization of WebElements
	@FindBy(xpath = "//*[@id='user-name']")
	WebElement userNameField;
	
	@FindBy(xpath = "//*[@id='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//*[@id='login-button']")
	WebElement loginBtn;

	//**************Action Methods**************
	public void loginToSwagApplication(String userName, String pass) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(pass);
		
		loginBtn.click();
		
		
		
		//1. Fetch URL
		//2. Use assertion to compare it with https://www.saucedemo.com/inventory.html
		
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, "https://www.saucedemo.com/inventory.html");
		
	}
	
	public void goTo() {
		driver.get("https://www.saucedemo.com/");
	}


}
