package com.guru99.demo.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestPages.EditCustomerPage;
import com.guru99.demo.TestPages.HomePage;
import com.guru99.demo.TestPages.LoginPage;

public class EditCustomerPageTest extends TestBase {

	public EditCustomerPageTest() {
		super();
	}

	LoginPage loginPage;
	HomePage homePage;
	EditCustomerPage editCustomerPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToApp(username, password);
		editCustomerPage = (EditCustomerPage) homePage.navigateToPage("EditCustomer");
	}

	@Test
	public void verifyEditCustomer() {
		// 42371
		String[] editCustomer = { "47648", "India", "Banglore", "Karnataka", "560000", "80000000000", "@gmail.com" };
		String msg = editCustomerPage.editCustomer(editCustomer);
		System.out.println(msg);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
