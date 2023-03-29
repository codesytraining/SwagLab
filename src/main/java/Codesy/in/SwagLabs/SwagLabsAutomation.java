package Codesy.in.SwagLabs;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsAutomation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\RohitData\\Eclipse\\SeleniumJARs\\chromedriver_win32_108\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();	
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//maximize()
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		ArrayList allProducts = new ArrayList();
		allProducts.add("Sauce Labs Backpack");
		allProducts.add("Sauce Labs Onesie");
		allProducts.add("Sauce Labs Bike Light");
		
		//***************Login***************
		
		driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
		
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		
		//******Verify if Login is Success or not********
		
		//***************Add 3 items into card***************
//		Sauce Labs Backpack
//		Sauce Labs Onesie
//		Sauce Labs Bike Light
		
		driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-onesie']")).click();
		driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']")).click();
		
		//***************Verify count of CART***************
		
		String itemCnt = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
		if(itemCnt.equals("3")) {
			System.out.println("We have 3 items into CART!!");
		}
		
		//***************Click on Cart***************
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		//***************Verify Cart Items***************		
		
		List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for(int i = 0; i < cartItems.size(); i++) {
			//System.out.println(cartItems.get(i).getText());
			
			if(allProducts.contains(cartItems.get(i).getText())) {
				System.out.println(cartItems.get(i).getText() + " product is Added into CART!!");
			}else {
				System.out.println(cartItems.get(i).getText() + " product is NOT Added into CART!!");
			}
		}
		
		//Click on CHECKOUT button
		driver.findElement(By.xpath("//*[@id='checkout']")).click();
		
		//Fill First Name, Last Name and Postal Code. Then click CONTINUE button
		
		driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("CODESY");
		driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("TRAINING");
		driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("411046");
		
		driver.findElement(By.xpath("//*[@id='continue']")).click();
		
		//Print Payment Information on CONSOLE
		
		String paymentInfo = driver.findElement(By.xpath("//div[@class='summary_value_label'][1]")).getText();
		System.out.println("Payment Info is: " + paymentInfo);
		
		//Click on FINISH
		driver.findElement(By.xpath("//*[@id='finish']")).click();
		
		//Check if THANK YOU FOR YOUR ORDER is displayed
		
		String thanksText = driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
		if(thanksText.contains("THANK YOU FOR YOUR ORDER")) {
			System.out.println("THANK YOU FOR YOUR ORDER text is displayed!!");
			
		}
		
		//Click on BACK HOME button
		driver.findElement(By.xpath("//*[@id='back-to-products']")).click();
		
		
		

	}

}
