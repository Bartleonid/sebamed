package com.sebamed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.sebamed.common.WebDriverUtility;
import com.sebamed.items.User;

public class StartPage extends WebDriverUtility {

	WebDriver driver;
	// Interface:
	By signinBtn = By.cssSelector(".sign-link>a");
	By email = By.cssSelector("#email-field");
	By password = By.cssSelector("#password-field");
	By signSubmit = By.cssSelector("#sign-submit");

	// Constructor - driver initialization.
	public StartPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method Login to adsy.com:
	public StartPage login(User user) throws InterruptedException {
		click(this.driver, signinBtn);
		type(this.driver, email, user.email);
		type(this.driver, password, user.password);
		click(this.driver, signSubmit);

		return new StartPage(driver);
	}

}
