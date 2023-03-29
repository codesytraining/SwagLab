package testCaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Codesy.in.SwagLabs.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		//Read "browser" property from GlobalData.properties file
		Properties prop = new Properties();
		
			//Convert .properties file to InputStream
		FileInputStream inpStrm = new FileInputStream("C:\\RohitData\\CODESY\\Selenium_Java\\Batch_18_Nov_2022\\TestingBatch\\SwagLabs\\src\\test\\java\\Resources\\GlobalData.properties"); 
		
		prop.load(inpStrm);		
		
		//Depending on "browser" value, invoke appropriate browser
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\RohitData\\Eclipse\\SeleniumJARs\\chromedriver_win32_108\\chromedriver.exe");
			
			driver = new ChromeDriver();	
			
			//implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//maximize()
			driver.manage().window().maximize();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			
		}else {
			System.out.println("Please give correct browser value into GlobalData.properties file!!");
		}
		
		return driver;
	}
	
	
	public WebDriver launchApplication() throws IOException {
		WebDriver driver = initializeDriver();
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.goTo();
		
		return driver;
	}
	
	public HashMap<String, String> readDataFromJSON(String pathOfJSON) throws IOException {
		
		//1. Read JSON file and convert it's data into String -> DEPENDANCY
		
		String fileData = FileUtils.readFileToString(new File(pathOfJSON), StandardCharsets.UTF_8);
		
		
		//2. Convern String data from 1st step into HashMap -> DEPENDANCY
		
		ObjectMapper obj = new ObjectMapper();
		HashMap<String, String> mapData = obj.readValue(fileData, new TypeReference<HashMap<String, String>>(){});
		
		//3. Return that HashMap object
		return mapData;
		
	}
	
	//Explicit Wait
	public void waitTillVisibilityOfElement(WebElement element, int sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Take Screenshot
	public String takeScreenshot(WebDriver driver, String testCaseName) throws IOException {
		//First Approach
		//Create WebElement Object
		//WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));	
		//File screen = firstName.getScreenshotAs(OutputType.FILE);
		
		//Second Approach
		//File screen =  driver.findElement(By.xpath("//*[@id='firstName']")).getScreenshotAs(OutputType.FILE);
		
		//***************Take screenshot of entire page******
		File screen =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png");
		
		FileUtils.copyFile(screen, file);
		
		return (System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png");
		
	}
	
	

}
