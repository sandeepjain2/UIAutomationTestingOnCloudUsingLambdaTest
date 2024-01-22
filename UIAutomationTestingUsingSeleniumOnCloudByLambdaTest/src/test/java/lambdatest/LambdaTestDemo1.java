package lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class LambdaTestDemo1 {
	
	WebDriver driver = null;

	
	@Test
	public void loginTest() throws MalformedURLException {		
		
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 11");
		browserOptions.setBrowserVersion("121.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "username");
		ltOptions.put("accessKey", "accessKey");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("project", "Untitled");
		ltOptions.put("selenium_version", "4.13.0");
		ltOptions.put("w3c", true);
		browserOptions.setCapability("LT:Options", ltOptions);
				
		driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		AssertJUnit.assertTrue(driver.getTitle().contains("OrangeHRM"));
		driver.quit();
		
	}	
}