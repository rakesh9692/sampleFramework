package SeleniumProject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumProject.pageobject.*;
import SeleniumProject.AbstractComponents.*;
import SeleniumProject.TestComponents.BaseTest;
import java.util.HashMap;

public class StandAloneTest extends BaseTest {
	String productname;

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {

		// add comments

		ProductCatalogue productcatalog = landingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productcatalog.getProductList();
		productcatalog.addProductToCart(input.get("productname"));
		AbstractComponents ac = new AbstractComponents(driver);

		CartPage cartpage = ac.geToCartPage();
		Boolean match = cartpage.verifyProductDisplay(input.get("productname"));

		Assert.assertTrue(match);
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.checkoutclick();
		checkout.fillCardDetails(input.get("productname"), "India");
		confirmationPage confirm = checkout.submitOrder();
		// change to soft assert
		String confirmmessage = confirm.getConfirmationMessage();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderPageValidation() {
		// verify order is displayed
		ProductCatalogue productcatalog = landingpage.loginApplication("rakesh9692@gmail.com", "Rakesh123");
		OrderPage orderpage = productcatalog.goToOrderPage();
		Assert.assertTrue(orderpage.verifyProductDisplay(productname));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

//		HashMap<String,String> map = new HashMap<String,String>();
//		map.put("email", "rakesh9692@gmail.com");
//		map.put("password", "Rakesh123");
//		map.put("productname", "ZARA COAT 3");
//		
//		HashMap<String,String> map1 = new HashMap<String,String>();
//		map1.put("email", "ram0101@gmail.com");
//		map1.put("password", "Rakesh123");
//		map1.put("productname", "ADIDAS ORIGINAL");

		List<HashMap<String, String>> data = getJsonToMap(
				System.getProperty("user.dir") + "\\src\\main\\java\\SeleniumProject\\data\\userdetails.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

//	@DataProvider
//	public Object[][] getData() {
//		
//		
//		return new Object[][] { {"rakesh9692@gmail.com","Rakesh123","ZARA 3"}, {map1} };
//	}

}
