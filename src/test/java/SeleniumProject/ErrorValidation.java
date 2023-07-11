package SeleniumProject;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumProject.pageobject.*;
import SeleniumProject.AbstractComponents.*;
import SeleniumProject.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	String productname = "ZARA COAT 3";

	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException {

		landingpage.loginApplication("rakesh9691@gmail.com", "Rakesh123");
		Assert.assertEquals("Incorrect  or password.", landingpage.getErrorLogin());

	}

	@Test
	public void productErrorValidation() throws IOException, InterruptedException {

		String productname = "ZARA COAT 3";

		ProductCatalogue productcatalog = landingpage.loginApplication("rakesh9692@gmail.com", "Rakesh123");
		productcatalog.getProductList();
		productcatalog.addProductToCart(productname);
		AbstractComponents ac = new AbstractComponents(driver);

		CartPage cartpage = ac.geToCartPage();
		Boolean match = cartpage.verifyProductDisplay("ZARA ##");

		Assert.assertFalse(match);

	}

}
