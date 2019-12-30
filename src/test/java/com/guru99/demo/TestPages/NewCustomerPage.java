package com.guru99.demo.TestPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestUtils.TestUtil;

public class NewCustomerPage extends TestBase {

	@FindBy(xpath = "//input[@name='name']")
	WebElement customerNameTxt;

	@FindBy(xpath = "//tr[5]//td[2]//input[1]")
	WebElement maleRadioBtn;

	@FindBy(xpath = "//tr[5]//td[2]//input[2]")
	WebElement femaleRadioBtn;

	@FindBy(xpath = "//input[@id='dob']")
	WebElement dateOfBirthTxt;

	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement addressTxtArea;

	@FindBy(xpath = "//input[@name='city']")
	WebElement cityTxt;

	@FindBy(xpath = "//input[@name='state']")
	WebElement stateTxt;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pinNoTxt;

	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement mobileNoTxt;

	@FindBy(xpath = "//input[@name='emailid']")
	WebElement emailTxt;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTxt;

	@FindBy(xpath = "//input[@name='sub']")
	WebElement submitBtn;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[4]/td[2]")
	WebElement custID;

	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public String addCustomer(String customer[]) {
		String msg = null;
		try {
			for (int j = 0; j < customer.length; j++) {
				TestUtil.sendKeys(customerNameTxt, TestUtil.randomestring(7));
				if (customer[j++].equalsIgnoreCase("M")) {
					TestUtil.click(maleRadioBtn);
				} else {
					TestUtil.click(femaleRadioBtn);
				}
				TestUtil.sendKeys(dateOfBirthTxt, customer[j++]);
				TestUtil.sendKeys(dateOfBirthTxt, customer[j++]);
				dateOfBirthTxt.sendKeys(Keys.TAB);
				Thread.sleep(2000);
				TestUtil.sendKeys(dateOfBirthTxt, customer[j++]);
				TestUtil.sendKeys(addressTxtArea, customer[j++]);
				TestUtil.sendKeys(cityTxt, customer[j++]);
				TestUtil.sendKeys(stateTxt, customer[j++]);
				TestUtil.sendKeys(pinNoTxt, TestUtil.randomeNum(6));
				TestUtil.sendKeys(mobileNoTxt, TestUtil.randomeNum(10));
				String email = TestUtil.randomestring(5) + customer[j++];
				j--;
				TestUtil.sendKeys(emailTxt, email);
				logger.info("Customer Email ID: " + email);
				TestUtil.sendKeys(passwordTxt, customer[j++]);
				TestUtil.click(submitBtn);
				if (TestUtil.isAlertPresent()) {
					alert = driver.switchTo().alert();
					msg = alert.getText();
					alert.accept();
					logger.info("Alert displayed: " + msg);
				} else {
					msg = custID.getText();
					System.out.println("Customer Id: " + msg);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in addCustomer: " + e);
		}
		return msg;
	}
}
