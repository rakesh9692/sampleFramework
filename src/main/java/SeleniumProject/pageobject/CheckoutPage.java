package SeleniumProject.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumProject.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		// helps to initializiaze the driver object for Page Factory(arg driver and this
		// constructor)
		PageFactory.initElements(driver, this);
	}

	// WebElement username = driver.findElement(By.id("userEmail"));

	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;

	@FindBy(xpath = "//*[@placeholder='Select Country']")
	WebElement selectCountrySelection;

	@FindBy(css = "section .ta-item:nth-of-type(2)")
	WebElement nthSelection;

	@FindBy(css = ".action__submit")
	WebElement submit;

	By selectCountry = By.xpath("//*[@placeholder='Select Country']");

	public void checkoutclick() {
		checkoutButton.click();

	}

	public void fillCardDetails(String productname, String country) throws InterruptedException {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		action.sendKeys(selectCountrySelection, country).build().perform();
		waitForElementToAppear(selectCountry);
		nthSelection.click();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);

	}

	public confirmationPage submitOrder() {

		submit.click();
		return new confirmationPage(driver);

	}

}
