package browser;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserClass 
{
	
	public static WebDriver openChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\Automation\\chromedriver.exe");
		
		//code for stop chrome browser notifications
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
			return driver;
	}

}
