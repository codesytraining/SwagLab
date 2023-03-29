package Codesy.in.SwagLabs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;		
	public CartPage(WebDriver driver) {		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Initialization of WebElements
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> inventoryItemName;
	
	//CHECKOUT button
	@FindBy(xpath = "//*[@id='checkout']")
	WebElement checkoutBtn;
			
	
	//Action Method
	public void verifyCartItems(ArrayList expectedProducts) {
		for(int i = 0; i < expectedProducts.size(); i++) {
						
			if(expectedProducts.contains(inventoryItemName.get(i).getText())) {
				System.out.println(inventoryItemName.get(i).getText() + " product is Added into CART!!");
			}else {
				System.out.println(inventoryItemName.get(i).getText() + " product is NOT Added into CART!!");
			}
		}
	}
	
	//Method to click on Checkout button
	public void checkout() {
		checkoutBtn.click();
	}
	
	

}
