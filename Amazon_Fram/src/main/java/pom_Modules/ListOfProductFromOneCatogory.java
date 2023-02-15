package pom_Modules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfProductFromOneCatogory 
{
	//Global Variable
		Actions act;
		WebDriver driverG;
		
	// variable
	@FindBy (xpath="(//div[@class=\"sg-col-inner\"])[6]//h2//span")
	private WebElement firstProduct;

	public ListOfProductFromOneCatogory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFirstProduct()
	{
		firstProduct.click();
	}
}
