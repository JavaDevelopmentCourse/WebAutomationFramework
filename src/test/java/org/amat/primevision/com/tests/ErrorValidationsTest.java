package org.amat.primevision.com.tests;

import org.amat.primevision.com.genericclass.BaseClass;
import org.amat.primevision.com.genericclass.Retry;
import org.amat.primevision.com.tests.pages.CartPage;
import org.amat.primevision.com.tests.pages.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ErrorValidationsTest extends BaseClass {

	@Test(groups = {"ErrorHandlingTest"},retryAnalyzer= Retry.class)
	public void LoginErrorValidation() {

	
		landingPage.loginApplications("szzagar.nitin08@gmail.com", "Nitin*88");
		assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	

@Test
	public void ProductErrorValidation() throws Exception {

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplications("sagar.nitin08@gmail.com", "Nitin*88");
    productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCharPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	

	}

	
	

}
