package com.guru99.demo.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestPages.HomePage;
import com.guru99.demo.TestPages.LoginPage;

public class LoginPageTest extends TestBase {

	public LoginPageTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void verifyValidLogin() {
		homePage = loginPage.loginToApp(username, password);
		if (homePage.isValidLogin(username)) {
			Assert.assertTrue(true);
			logger.info("verifyValidLogin passed");
		} else {
			Assert.assertTrue(false);
			logger.info("verifyValidLogin failed");
		}

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}
