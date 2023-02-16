package pom_Modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header 
{	
	
	//String "Sonal";
	WebDriver driver ;
	private Actions act ;
	@FindBy (xpath = "//span[@class='nav-line-2 ']")
	private WebElement accountAndList ;	
	
	@FindBy (xpath="(//span[text()='Sign in'])[1]")
	private WebElement signBtn;
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchbox;

	@FindBy (xpath="//input[@type='submit']")
	private WebElement searchbtn;
	
	@FindBy (xpath = "(//a [text()='Start here.'])[1]")
	private WebElement startHere ;
	
	@FindBy (xpath="//span[@id='nav-cart-count']")
 	private WebElement cartCOUNT;
	
	
	public Header (WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
	}

	public void MoveOnAccountAndList()
	{
		act.moveToElement(accountAndList).moveToElement(startHere).click().build().perform();
	}
	

	public void clickOnSearchBox(String product)
	{
		searchbox.sendKeys(product);		
	}
	public void clickOnSearchbtnIcon()
	{
		searchbtn.click();
	}
	
	public int cartCOUNT()	
	{	String countCart=cartCOUNT.getText();	
	     int cartCount= Integer.parseInt(countCart);
	    return cartCount;
	 }
}
