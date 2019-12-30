package com.guru99.demo.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestUtils.TestUtil;

public class EditCustomerPage extends TestBase {

	@FindBy(how = How.XPATH, using = "//input[@name='cusid']")
	WebElement customerIdTxt;

	@FindBy(how = How.XPATH, using = "//input[@name='AccSubmit']")
	WebElement cutSubmitBtn;

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

	@FindBy(xpath = "//input[@name='sub']")
	WebElement editSubmitBtn;

	@FindBy(xpath = "//p[@class='heading3']")
	WebElement successMsg;

	public EditCustomerPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public String editCustomer(String editCustomer[]) {
		String msg = "";
		try {
			for (int i = 0; i < editCustomer.length; i++) {
				TestUtil.sendKeys(customerIdTxt, editCustomer[i++]);
				TestUtil.click(cutSubmitBtn);
				Thread.sleep(2000);
				TestUtil.sendKeys(addressTxtArea, editCustomer[i++]);
				TestUtil.sendKeys(cityTxt, editCustomer[i++]);
				TestUtil.sendKeys(stateTxt, editCustomer[i++]);
				TestUtil.sendKeys(pinNoTxt, editCustomer[i++]);
				TestUtil.sendKeys(mobileNoTxt, editCustomer[i++]);
				String email = TestUtil.randomestring(5) + editCustomer[i++];
				i--;
				TestUtil.sendKeys(emailTxt, email);
				logger.info("Customer's updated Email ID: " + email);
				TestUtil.click(editSubmitBtn);
				msg = successMsg.getText();
				logger.info("Customer updated message: " + msg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in editCustomer: " + e);
		}
		return msg;
	}

}
