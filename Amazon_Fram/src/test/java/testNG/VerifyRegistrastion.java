package testNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browser.BrowserClass;
import pom_Modules.Header;
import pom_Modules.Registration;
import utils.Utility;


public class VerifyRegistrastion extends BrowserClass
{
	private WebDriver driver;
	private Header header;
	private Registration registration;
	private SoftAssert soft;
	private String TestId;
	private int row = 1;
	@Parameters("browser123")
	@BeforeTest
	public void lauchBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
		//driver.manage().window().maximize();		
	}
	
	@BeforeClass
	public void CreateObjects()
	{
		 header       = new Header(driver);
		 registration = new Registration(driver);
		 soft         = new SoftAssert();
		 
		 
	}

	@BeforeMethod
	public void lunchUrl()
	{
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hmh5l8jr5_e&adgrpid=61764313147&hvpone=&hvptwo=&hvadid=610644605475&hvpos=&hvnetw=g&hvrand=8780691097501803846&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9299648&hvtargid=kwd-327061083&hydadcr=14455_2316418&gclid=CjwKCAiAioifBhAXEiwApzCzti8SmV4TVIWbXexjHA3kFNHlFeQ-xHeOkOE8QIQRupZ_pbweYBR_hxoC_c0QAvD_BwE");
	}
	//test-1
	@Test(invocationCount = 2)
	public void verifyRegistration() throws IOException 
	{
		TestId = "TID01";
		
		header.MoveOnAccountAndList();
		String actualNameLabelText = registration.verifyNameText();
		String expectedNameLabelText = "Your name";
	// using soft assert validate name label text
		soft.assertEquals(actualNameLabelText, expectedNameLabelText, "Name Lable Text is wrong");
	//get name from excelSheet
		String name = Utility.getDataFromExcel("registration", row, 0);
		registration.sendName(name);
		
	//verify mobile label text
		String actualMobileText = registration.verifymobileText();
		String expectedMobileText = "Mobile number";
		soft.assertEquals(actualMobileText, expectedMobileText, "Mobile Lable Text is wrong");
	//get mobile from excelSheet
		String mobile = Utility.getDataFromExcel("registration", row, 1);

		registration.sendMobile(mobile);
	//verify mobile label text
		String actualPassText = registration.verifyPasswordText();
		System.out.println(actualPassText);
		String expectedPassText = "Password";
		soft.assertEquals(actualPassText, expectedPassText, "password Lable Text is wrong");
	//get pass from excelSheet
		String pass = Utility.getDataFromExcel("registration", row, 2);
		registration.sendPassword(pass);
		soft.assertAll();
	
		//registration.clickOnContinueButton();
		row++;
		
	}
	
	@AfterMethod
	public void takeScreenShotOfFailMethod(ITestResult result) throws IOException//ITest is the listener of testNg framework
	{
		if(ITestResult.FAILURE ==result.getStatus())
		{
			Utility.captureScreenShot(TestId, driver);

		}
	}
	@AfterClass
	public void makeNullAllObjects()
	{
		//make null all object references here
		header = null;
	}
	@AfterTest
	public void closeBrowser()
	{
		//driver.quit();
		driver = null;
		System.gc();// garbage collection is remove all references from memory 
	}
}
