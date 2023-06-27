package SeleniumProject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumProject.AbstractComponents.AbstractComponents;

public class confirmationPage extends AbstractComponents {

	WebDriver driver;
	
	@FindBy(css= ".hero-primary")
	WebElement confirmText;

	public confirmationPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		// helps to initializiaze the driver object for Page Factory(arg driver and this
		// constructor)
		PageFactory.initElements(driver, this);
	}
	
	public String getConfirmationMessage() {
		return confirmText.getText();
		
	}

}
