package pom_Modules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPage 
{
	//Global Variable
		Actions act;
		WebDriver driverG;
							
	//variable
		
		@FindBy (xpath="//div[@id='corePriceDisplay_desktop_feature_div']//span[2]//span[2]//span[2]")
		private WebElement productMRP;
		
		@FindBy (xpath="(//span[@class='a-offscreen'])[6]")
		private WebElement productDiscount;
		
		@FindBy (xpath="//div[@id='corePriceDisplay_desktop_feature_div']//span[2]//span[2]//span[2]")
		private WebElement productDiscountPrice;
		
		@FindBy (xpath="//input[@id='add-to-cart-button']")
		private WebElement addToCart;
		
		@FindBy (xpath="//a[@id='attach-close_sideSheet-link']")
		private WebElement closeBtnCartPopup;
		
		@FindBy (xpath="//h1[@id='title']//span[@id='productTitle']")//smartTV name//mobile name
		private WebElement productName;
		//h1[@id='title']//span[@id='productTitle']
		
		@FindBy (xpath="//span[@id='huc-view-your-list-button']")
		private WebElement viewWishBtn;
		
		@FindBy (xpath="//input[@id='add-to-wishlist-button-submit']")
		private WebElement addWishBtn;
					
		public ProductDisplayPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
	//methods
		public String getproductMRP()
		{
			String MRP = productMRP.getText();
			return MRP;
		}
		public String getDiscountOnproduct()
		{
			String dis = productDiscount.getText();
			return dis;
			
		}
		public String getProductDiscountedPrice()	
		{	
			String productPrice= productDiscountPrice.getText();	
		    return  productPrice;	
		}
		
		
		public void clickOnAdd2cart()	
		{	
			addToCart.click();	  
		}
		
		public void clickCloseBtnofCartPopup()	
		{	
			closeBtnCartPopup.click();	 
			
		}
		
		
		public boolean checkCloseBtnofCartPopup()	
		{	
			boolean result=closeBtnCartPopup.isDisplayed(); 
		       return result; 
		 }
		
		
		public String getProductName()	
		{	
			String productSpName =	productName.getText() ;
		    return productSpName;
		 }
		
		public void clickonViewWishListBtnPopup()	
		{	
			viewWishBtn.click();	  
		}
		
		public void clickonAddWishListBtn()	
		{	
			addWishBtn.click();	  
		}
}
