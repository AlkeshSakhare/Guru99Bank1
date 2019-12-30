package com.guru99.demo.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestPages.HomePage;
import com.guru99.demo.TestPages.LoginPage;
import com.guru99.demo.TestPages.NewCustomerPage;

public class NewCustomerPageTest extends TestBase {

	public NewCustomerPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}

	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToApp(username, password);
		newCustomerPage = (NewCustomerPage) homePage.navigateToPage("NewCustomer");
	}

	@Test
	public void verifyAddCustomer() {
		String[] customer = { "M", "01", "Nov", "2019", "Goregaon", "Mumbai", "MH", "@gmail.com", "abcdef" };
		String msg = newCustomerPage.addCustomer(customer);
		System.out.println("Add customer Msg: " + msg);

	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}
