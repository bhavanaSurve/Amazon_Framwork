package testNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browser.BrowserClass;
import pom_Modules.Header;
import pom_Modules.ListOfProductFromOneCatogory;
import pom_Modules.ProductDisplayPage;
import utils.Utility;

public class VerifyBuyProduct extends BrowserClass
{
	private int row = 1;
	private WebDriver driver;
	private Header header;
	private ProductDisplayPage productDisplayPage;
	private ListOfProductFromOneCatogory listOfProductFromOneCatogory;
	private SoftAssert soft ;
	@Parameters("browser123")
	@BeforeTest
	public void openBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			driver = openChromeBrowser();
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		}
	}
	@BeforeClass
	public void createObjects()
	{
		header                       = new Header(driver);
		listOfProductFromOneCatogory = new ListOfProductFromOneCatogory(driver);
		productDisplayPage           = new ProductDisplayPage(driver);
	}
	
	@BeforeMethod
	public void launchURL()
	{
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hmh5l8jr5_e&adgrpid=61764313147&hvpone=&hvptwo=&hvadid=610644605475&hvpos=&hvnetw=g&hvrand=8780691097501803846&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9299648&hvtargid=kwd-327061083&hydadcr=14455_2316418&gclid=CjwKCAiAioifBhAXEiwApzCzti8SmV4TVIWbXexjHA3kFNHlFeQ-xHeOkOE8QIQRupZ_pbweYBR_hxoC_c0QAvD_BwE");
		header.clickOnSearchBox("mobile");
		header.clickOnSearchbtnIcon();
		// scroll down to see product
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(00,250)");
		
		
		
	}
	@Test
	public void verifyAddtoCartProduct() throws EncryptedDocumentException, IOException
	{
	// click on first product
		listOfProductFromOneCatogory.clickOnFirstProduct();
		
	//Shift selenium focus on child window
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
	// verification
		soft = new SoftAssert();
		String actulProductName    = productDisplayPage.getProductName();
		String expectedProductName = Utility.getDataFromExcel("productDisplayPage",row , 0);
		soft.assertEquals(actulProductName, expectedProductName, "product Name is Wrong");
		
		String actualMRP   = productDisplayPage.getproductMRP();
		String expectedMRP = Utility.getDataFromExcel("productDisplayPage",row , 1);
		soft.assertEquals(actualMRP, expectedMRP, "MRP is wrong");
		
		String actualDiscount   = productDisplayPage.getDiscountOnproduct();
		String expectedDiscount = Utility.getDataFromExcel("productDisplayPage",row , 2);
		soft.assertEquals(actualDiscount, expectedDiscount, "given discount  is wrong");
		
		String actualDiscountPrice   = productDisplayPage.getProductDiscountedPrice();
		String expectedDiscountPrice = Utility.getDataFromExcel("productDisplayPage",row , 3);
		soft.assertEquals(actualDiscountPrice, expectedDiscountPrice, "given discount  is wrong");
		soft.assertAll();
	}
	
	@AfterClass
	public void makeAllObjectsNull()
	{
		header                       = null;
		listOfProductFromOneCatogory = null;
	}
	@AfterTest
	public void closeBrowser()
	{
		//driver.quit();
		driver = null;
		System.gc();
	}

}
