package SeleniumProject.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumProject.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		// helps to initializiaze the driver object for Page Factory(arg driver and this
		// constructor)
		PageFactory.initElements(driver, this);
	}

	// WebElement username = driver.findElement(By.id("userEmail"));

	// Page Factory

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement ngMessage;

	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".mb-3 .fa-shopping-cart");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}

	public WebElement getProductByName(String productname) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String productname) {
		WebElement prod = getProductByName(productname);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(ngMessage);
	}
}
