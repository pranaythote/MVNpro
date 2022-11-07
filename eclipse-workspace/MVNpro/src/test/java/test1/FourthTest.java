package test1;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resoureces.Base1;

public class FourthTest extends Base1 {
	
	// if you want to screenshot for failure class and run into the testNg for listener class
	// then it not took the screenshot 
	//make sure Webdriver driver is public or not
	// all test should be WebDriver driver is Global and public

	public WebDriver driver;

	@Test
	public void TestFour() throws IOException, InterruptedException {
		System.out.println("Test Four Run");

		driver = intializeBrowser();

		driver.get("http://tutorialsninja.com/demo/");

		Thread.sleep(2000);

		Assert.assertTrue(false);
	}

	@AfterMethod
	public void colsureBrowser() {
		driver.close();
	}
}
