package pom_Modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration 
{
	private WebDriver driver;
	
	@FindBy (xpath = "//input[@id='ap_customer_name']")
	private WebElement yourName;
	
	@FindBy (xpath = "(//label[@class='a-form-label'])[1]")
	private WebElement nameLabel;
	
	@FindBy (xpath = "//input[@id='ap_phone_number']")
	private WebElement mobile;
	
	@FindBy (xpath = "//label[@class='a-form-label auth-mobile-label']")
	private WebElement mobileLabel;
	
	@FindBy (xpath = "//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy (xpath = "//label[@for='ap_password']")
	private WebElement passwordLabel;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continueButton;
	
	
	
	
	
	public Registration(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public String verifyNameText()
	{
		String name = nameLabel.getText();
		return name;
	}
	public void sendName(String name)
	{
		yourName.sendKeys(name);
	}
	
	public String verifymobileText()
	{
		String mobile = mobileLabel.getText();
		return mobile;
	}
	public void sendMobile(String mobile1)
	{
		mobile.sendKeys(mobile1);
	}
	
	public String verifyPasswordText()
	{
		String pass = passwordLabel.getText();
		return pass;
	}

	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	}
