package SeleniumProject.AbstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponents {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		// Driver initialization
		super(driver);
		this.driver = driver;
		// Initializes the driver object for Page Factory
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='ng-star-inserted']//tr//td[2]")
	private List<WebElement> orderedProducts;

	/***
	 * 
	 * @param productname
	 * @return Boolean value if added product is displayed
	 */
	public Boolean verifyProductDisplay(String productname) {
		Boolean match = orderedProducts.stream().anyMatch(cart -> cart.getText().equals(productname));
		// driver.findElement(By.cssSelector(".totalRow button")).click();
		return match;

	}

}
