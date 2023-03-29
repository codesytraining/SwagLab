package Codesy.in.SwagLabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
	
	WebDriver driver;		
	public AboutPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	
	
	//Action Methods
	public boolean validateTitle(String expectedTitle) {
		
		boolean result;
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			result = true;
			
		}else {
			result = false;
		}
		
		return result;
	}
}
