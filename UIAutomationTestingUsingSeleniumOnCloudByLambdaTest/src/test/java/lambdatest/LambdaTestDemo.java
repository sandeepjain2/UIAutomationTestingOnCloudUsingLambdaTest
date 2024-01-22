package lambdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LambdaTestDemo {
	
	
WebDriver driver = null;

	@Parameters({"browserName","browserVersion","osVersion"})

	@Test
	public void loginTestDemo(String browserName,String browserVersion,String osVersion) throws MalformedURLException, InterruptedException {
		
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "username");
		ltOptions.put("accessKey", "accessKey");
		ltOptions.put("visual", true);
		ltOptions.put("video", true);
		ltOptions.put("project", "UIAutomation");
		ltOptions.put("build", "SeleniumAutomation");
		ltOptions.put("selenium_version", "4.13.0");
		ltOptions.put("w3c", true);
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			ChromeOptions browserOptions = new ChromeOptions();			
			browserOptions.setPlatformName(osVersion);			
			browserOptions.setBrowserVersion(browserVersion);		
			browserOptions.setCapability("LT:Options", ltOptions);			
			driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);			
			
		} else if(browserName.equalsIgnoreCase("Firefox")){
			
			FirefoxOptions browserOptions = new FirefoxOptions();			
			browserOptions.setPlatformName(osVersion);			
			browserOptions.setBrowserVersion(browserVersion);		
			browserOptions.setCapability("LT:Options", ltOptions);			
			driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
			
		} else if(browserName.equalsIgnoreCase("Edge")){
			
			EdgeOptions browserOptions = new EdgeOptions();			
			browserOptions.setPlatformName(osVersion);			
			browserOptions.setBrowserVersion(browserVersion);		
			browserOptions.setCapability("LT:Options", ltOptions);			
			driver=new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
		}
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		AssertJUnit.assertTrue(driver.getTitle().contains("OrangeHRM"));
		Thread.sleep(5000);
		driver.quit();
		
	}	

}
