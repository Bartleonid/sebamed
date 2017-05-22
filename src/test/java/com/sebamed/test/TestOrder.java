package com.sebamed.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sebamed.common.WebDriverUtility;
import com.sebamed.items.CreditCard;
import com.sebamed.items.Items;
import com.sebamed.items.User;
import com.sebamed.pages.HomePage;

public class TestOrder extends WebDriverUtility {

	User visitor = new User("lenjatest@gmail.com", "sebamed33");
	Items items = new Items(10);
	CreditCard creditCard = new CreditCard("4242424242424242", "01/19", "123", "TestUser", "Lenja Test",
			"United States", "Texas", "Houston", "+1 713-798-4857");

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { visitor } };
	}

	@Test(dataProvider = "getData")
	public void Order(User user) throws InterruptedException {
		start();
		HomePage homePage = new HomePage(driver);
		closeModalPopUp(homePage.closeModal);
		homePage.login(visitor);
		compareElement(homePage.expectedElement);
		homePage.selectProducts(items);
		homePage.payByCreditCard(creditCard);

		driver.quit();
	}

}