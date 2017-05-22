package com.sebamed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sebamed.common.WebDriverUtility;
import com.sebamed.items.CreditCard;
import com.sebamed.items.Items;
import com.sebamed.items.User;

public class HomePage extends WebDriverUtility {

	WebDriver driver;
	// Interface:
	By signinBtn = By.cssSelector(".sign-link>a");
	By email = By.cssSelector("#email-field");
	By password = By.cssSelector("#password-field");
	By signSubmit = By.cssSelector("#sign-submit");
	public By myAccount = By.cssSelector("#dLabel");
	public By closeModal = By.cssSelector(".close.modal-close");
	public String expectedElement = "MY ACCOUNT";
	By backToShop = By.cssSelector(".main-menu-item.uppertext>a[href='/']");
	By ourProducts = By.cssSelector(".main-menu__link[href='/sebamed-products']");
	By everyDay = By.cssSelector("[title='Sebamed Everyday Shampoo - 200 ml']");
	By quantity = By.cssSelector("div[id='inside-product-cart-form']>div>div>div>[id='quant-value']");
	By addToBag = By.cssSelector("div[id='inside-product-cart-form']>div>div>div>[id='add-to-cart-button']");
	By checkout = By.cssSelector(".checkout-button.custom-btn.primary-btn");
	By creditCard = By.cssSelector("#credit-card-number");
	By expiration = By.cssSelector("#credit-card-exp");
	By cvv = By.cssSelector("#credit-card-cvv");
	By nameOnCard = By.cssSelector("#credit-card-name");
	By completeOrder = By.cssSelector("#complete-order-submit");
	By completeName = By.cssSelector("[data-label='Complete name:']");
	By shipAddress = By.cssSelector("#google_ship_address");
	By state = By.cssSelector("#ship_stateSelectBoxItArrowContainer");
	By shipCiity = By.cssSelector("[name='ship_city']");
	By phone = By.cssSelector("#ship_phone_number");

	// Constructor - driver initialization.
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Method Login:
	public HomePage login(User user) throws InterruptedException {
		click(this.driver, signinBtn);
		type(this.driver, email, user.email);
		type(this.driver, password, user.password);
		click(this.driver, signSubmit);

		return new HomePage(driver);
	}

	public HomePage selectProducts(Items items) throws InterruptedException {
		click(this.driver, backToShop);
		click(this.driver, ourProducts);
		click(this.driver, everyDay);
		click(this.driver, quantity);
		type(this.driver, quantity, items.quantity);
		click(this.driver, addToBag);
		click(this.driver, checkout);

		return new HomePage(driver);
	}

	public HomePage payByCreditCard(CreditCard crediCard) throws InterruptedException {
		type(this.driver, creditCard, crediCard.cardNumber);
		type(this.driver, expiration, crediCard.expiration);
		type(this.driver, cvv, crediCard.cvv);
		type(this.driver, nameOnCard, crediCard.nameOnCard);
		click(this.driver, completeName);
		type(this.driver, completeName, crediCard.completeName);
		click(this.driver, shipAddress);
		type(this.driver, shipAddress, crediCard.shipAddress);
		click(this.driver, state);
		type(this.driver, state, crediCard.state);
		type(this.driver, shipCiity, crediCard.shipCiity);
		type(this.driver, phone, crediCard.phone);
		click(this.driver, completeOrder);

		return new HomePage(driver);

	}
}
