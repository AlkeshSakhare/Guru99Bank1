package com.guru99.demo.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99.demo.TestBase.TestBase;
import com.guru99.demo.TestUtils.TestUtil;

public class LoginPage extends TestBase {

	@FindBy(name = "uid")
	WebElement useridTxt;

	@FindBy(name = "password")
	WebElement passwordTxt;

	@FindBy(name = "btnLogin")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage loginToApp(String username, String password) {
		TestUtil.sendKeys(useridTxt, username);
		TestUtil.sendKeys(passwordTxt, password);
		TestUtil.click(loginBtn);
		return new HomePage();
	}
}
