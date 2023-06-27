package SeleniumProject.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumProject.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		//helps to initializiaze the driver object for Page Factory(arg driver and this constructor)
		PageFactory.initElements(driver, this);
	}

	//WebElement username = driver.findElement(By.id("userEmail"));

	
	@FindBy(xpath ="//*[@routerlink='/dashboard/cart']")
	WebElement cartbutton;
	
	@FindBy(xpath = "//*[@class='cart']//h3")
	private List<WebElement> cartproduct;
	
	
	public Boolean verifyProductDisplay(String productname) {
		Boolean match = cartproduct.stream().anyMatch(cart->cart.getText().equals(productname));
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		return match;
	}
	

}
