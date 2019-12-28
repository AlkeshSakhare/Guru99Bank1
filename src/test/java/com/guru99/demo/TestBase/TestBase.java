package com.guru99.demo.TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.guru99.demo.TestUtils.WebEventListener;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static String browser;
	public static String url;
	public static String username;
	public static String password;
	public static Properties properties;
	public static WebDriver driver;
	public static Actions actions;
	public static JavascriptExecutor js;
	public static NgWebDriver ngWebDriver;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	public static Logger logger;
	public static String userdir = System.getProperty("user.dir");
	public static Alert alert;

	public TestBase() {
		properties = new Properties();
		try {
			properties.load(new FileReader(userdir + "/src/test/java/com/guru99/demo/TestConfig/config.properties"));
			logger = Logger.getLogger("Guru99Bank");
			PropertyConfigurator.configure(userdir + "/src/test/java/com/guru99/demo/TestConfig/log4j.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initialization() {

		browser = properties.getProperty("browser");
		url = properties.getProperty("url");
		username = properties.getProperty("username");
		password = properties.getProperty("password");

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		js = (JavascriptExecutor) driver;
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
}
