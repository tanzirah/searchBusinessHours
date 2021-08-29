package steps;

import org.openqa.selenium.chrome.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks{
	private static WebDriver driver = null;
		
	@Before
	public void setup() {
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver");
		
		Hooks.driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);		
	}
	
	public static WebDriver getDriver() {
		return driver; 
	}

	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
	
	
}