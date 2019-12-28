package com.guru99.demo.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestUtils.TestUtil;

public class ChangePasswordPage extends TestBase {

	@FindBy(xpath = "//input[@name='oldpassword']")
	WebElement oldPasswordTxt;

	@FindBy(xpath = "//input[@name='newpassword']")
	WebElement newPasswordTxt;

	@FindBy(xpath = "//input[@name='confirmpassword']")
	WebElement confirmPasswordTxt;

	@FindBy(xpath = "//input[@name='sub']")
	WebElement submitPasswordBtn;

	public ChangePasswordPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public String changePassword() {
		TestUtil.sendKeys(oldPasswordTxt, password);
		int no = (int) (Math.random() * 10);
		String newPass = "NewPass@" + String.valueOf(no);
		logger.info("New password changed to " + newPass);
		System.out.println("NewPassword is: " + newPass);
		TestUtil.sendKeys(newPasswordTxt, newPass);
		TestUtil.sendKeys(confirmPasswordTxt, newPass);
		TestUtil.click(submitPasswordBtn);
		alert = driver.switchTo().alert();
		System.out.println("Success Message:" + alert.getText());
		logger.info("Success Message:" + alert.getText());
		alert.accept();
		return newPass;

	}

}
