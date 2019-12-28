package com.guru99.demo.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestUtils.TestUtil;

public class HomePage extends TestBase {

	public static Object pageObject;

	@FindBy(xpath = "//td[contains(text(),'Manger Id')]")
	WebElement loginUserId;

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newCustomerLink;

	@FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
	WebElement editCustomerLink;

	@FindBy(xpath = "//ul[@class='menusubnav']//a[contains(text(),'Delete Customer')]")
	WebElement deleteCustomerLink;

	@FindBy(xpath = "//a[contains(text(),'New Account')]")
	WebElement newAccountLink;

	@FindBy(xpath = "//a[contains(text(),'Edit Account')]")
	WebElement editAccountLink;

	@FindBy(xpath = "//a[contains(text(),'Delete Account')]")
	WebElement deleteAccountLink;

	@FindBy(xpath = "//a[contains(text(),'Deposit')]")
	WebElement depositLink;

	@FindBy(xpath = "//a[contains(text(),'Withdrawal')]")
	WebElement withdrawalLink;

	@FindBy(xpath = "//a[contains(text(),'Fund Transfer')]")
	WebElement fundTransferLink;

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	WebElement changePasswordLink;

	@FindBy(xpath = "//a[contains(text(),'Balance Enquiry')]")
	WebElement balanceEnquiryLink;

	@FindBy(xpath = "//a[contains(text(),'Mini Statement')]")
	WebElement miniStatementLink;

	@FindBy(xpath = "//a[contains(text(),'Customised Statement')]")
	WebElement customizedStatementLink;

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logoutLink;

	public boolean isValidLogin(String username) {
		if (loginUserId.getText().contains(username)) {
			return true;
		} else
			return false;
	}

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public Object navigateToPage(String pageName) {

		switch (pageName) {
		case "NewCustomer":
			TestUtil.click(newCustomerLink);
			pageObject = new NewCustomerPage();
			break;
		case "EditCustomer":
			TestUtil.click(editCustomerLink);
			pageObject = new EditCustomerPage();
			break;
		case "DeleteCustomer":
			TestUtil.click(deleteCustomerLink);
			pageObject = new DeleteCustomerPage();
			break;
		case "NewAccount":
			TestUtil.click(newAccountLink);
			pageObject = new NewAccountPage();
			break;
		case "EditAccount":
			TestUtil.click(editAccountLink);
			pageObject = new EditAccountPage();
			break;
		case "DeleteAccount":
			TestUtil.click(deleteAccountLink);
			pageObject = new DeleteAccountPage();
			break;
		case "Deposit":
			TestUtil.click(depositLink);
			pageObject = new DepositPage();
			break;
		case "Withdrawal":
			TestUtil.click(withdrawalLink);
			pageObject = new WithdrawalPage();
			break;
		case "FundTransfer":
			TestUtil.click(fundTransferLink);
			pageObject = new FundTransferPage();
			break;
		case "ChangePassword":
			TestUtil.click(changePasswordLink);
			pageObject = new ChangePasswordPage();
			break;
		case "BalanceEnquiry":
			TestUtil.click(balanceEnquiryLink);
			pageObject = new BalanceEnquiryPage();
			break;
		case "MiniStatement":
			TestUtil.click(miniStatementLink);
			pageObject = new MiniStatementPage();
			break;
		case "CustomizeStatement":
			TestUtil.click(customizedStatementLink);
			pageObject = new CustomizeStatementPage();
			break;
		case "Login":
			TestUtil.click(logoutLink);
			pageObject = new LoginPage();
			break;
		}
		return pageObject;
	}

}
