package SeleniumProject.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumProject.AbstractComponents.AbstractComponents;
import SeleniumProject.TestComponents.BaseTest;
import SeleniumProject.pageobject.CartPage;
import SeleniumProject.pageobject.CheckoutPage;
import SeleniumProject.pageobject.LandingPage;
import SeleniumProject.pageobject.ProductCatalogue;
import SeleniumProject.pageobject.confirmationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {
	
	public LandingPage landingpage;
	public ProductCatalogue productcatalog;
	List<WebElement> products;

	@Given("I landed on ecommerce page")
	public void landingPage() throws IOException{
		landingpage= launchApplication();
		
	}
	
	@Given("^User Login with username (.+) and password (.+)$")
	public void login(String name, String password) {
	 productcatalog = landingpage.loginApplication(name,password);
	}
	
	@When("^I add a product (.+) to cart$")
	public void addProduct(String productname) {
		products = productcatalog.getProductList();
		productcatalog.addProductToCart(productname);
	}
	@When("^checkout (.+) and submit the order$")
	public void submitOrder(String productname) throws InterruptedException {
		AbstractComponents ac = new AbstractComponents(driver);
		CartPage cartpage = ac.geToCartPage();
		Boolean match = cartpage.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.checkoutclick();
		checkout.fillCardDetails(productname, "India");
		checkout.submitOrder();
	}
		
	@Then("I verify the {string} message in screen.")
	public void verifyMessage(String string) {
		confirmationPage confirmationPage = new confirmationPage(driver);
		String confirmmessage= confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase(string));
	}
}
