package SeleniumProject.AbstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponents {
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		//helps to initializes the driver object for Page Factory(arg driver and this constructor)
		PageFactory.initElements(driver, this);
	}

	//WebElement username = driver.findElement(By.id("userEmail"));

	
	
	@FindBy(xpath = "//*[@class='ng-star-inserted']//tr//td[2]")
	private List<WebElement> orderedProducts;
	
	
	public Boolean verifyProductDisplay(String productname) {
		Boolean match = orderedProducts.stream().anyMatch(cart->cart.getText().equals(productname));
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		return match;
		
	
	}
	

}
