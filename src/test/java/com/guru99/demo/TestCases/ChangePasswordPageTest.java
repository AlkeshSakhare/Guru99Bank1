package com.guru99.demo.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestPages.ChangePasswordPage;
import com.guru99.demo.TestPages.HomePage;
import com.guru99.demo.TestPages.LoginPage;

public class ChangePasswordPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ChangePasswordPage changePasswordPage;

	public ChangePasswordPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToApp(username, password);
		changePasswordPage = (ChangePasswordPage) homePage.navigateToPage("ChangePassword");
	}

	@Test
	public void verifyChangePassword() {
		String newPassword = changePasswordPage.changePassword();
		loginPage.loginToApp(username, newPassword);
		if (homePage.isValidLogin(username)) {
			Assert.assertTrue(true);
			logger.info("User loggd in with new password: " + newPassword);
		} else {
			Assert.assertTrue(false);
			logger.info("Password not updated to : " + newPassword);
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
