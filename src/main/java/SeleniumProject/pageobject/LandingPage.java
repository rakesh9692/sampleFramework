package SeleniumProject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumProject.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		//helps to initializiaze the driver object for Page Factory(arg driver and this constructor)
		PageFactory.initElements(driver, this);
	}

	//WebElement username = driver.findElement(By.id("userEmail"));
	
	//Page Factory
	@FindBy(id ="userEmail")
	WebElement username;
	@FindBy(id = "userPassword")
	WebElement userPassword;
	@FindBy(xpath = "//*[@id='login']")
	WebElement loginButton;
	@FindBy(css = "[class*='flyInOut ']")
	WebElement incorrectLogin;
	
	//Action Method- to perform login Activities
	public ProductCatalogue loginApplication(String email, String password) {
		username.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
		ProductCatalogue productcatalog = new ProductCatalogue(driver);
		return productcatalog;
	}
	
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorLogin() {
		waitForElementToAppearElement(incorrectLogin);
		return incorrectLogin.getText();
		
	}
}
