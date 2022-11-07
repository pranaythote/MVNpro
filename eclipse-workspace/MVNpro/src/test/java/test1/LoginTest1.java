package test1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject1.AccountPage1;
import pageObject1.LandingPage1;
import pageObject1.LoginPage1;
import resoureces.Base1;

public class LoginTest1 extends Base1 {
	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void OpenApplication() throws IOException {

		// always remember in testNG before methode will exicuted first so logManager is
		// always in @Beforemethode
		// in loger appy we nead to download some build in pom.xml file
		// Search for 'Maven filtering' in google and add
		/*
		 * <resources> <resource> <directory>src/main/java/resources</directory>
		 * <filtering>true</filtering> </resource> ... </resources>
		 */

		// Remember if you want to run log and it does not creat folder after refreshing
		// our project
		// then we have to remove conditions and thowables
		// like if else and try catch blocks

		log = LogManager.getLogger(LoginTest1.class.getName());

		driver = intializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test(dataProvider = "getLogindata")
	public void openingBrowser(String email, String password, String Expectedresult)
			throws IOException, InterruptedException {

		LandingPage1 landingpage = new LandingPage1(driver);
		landingpage.MyaccountDropDown().click();
		log.debug("Clicked on My Account dropdown");
		landingpage.LoginOption().click();
		log.debug("Clicked on login option");

		Thread.sleep(3000);

		LoginPage1 login = new LoginPage1(driver);
		login.emailid().sendKeys(email);
		log.debug("Email addressed got entered");
		login.passwordFild().sendKeys(password);
		log.debug("Password got entered");
		login.LoginField().click();
		log.debug("Clicked on Login Button");

		AccountPage1 accountPage = new AccountPage1(driver);

		String actualResult = null;
		try {
			if (accountPage.editAccount().isDisplayed()) {
				log.debug("User got logged in");
				actualResult = "Successfull";
			}
		} catch (Exception e) {
			log.debug("User didn't log in");
			actualResult = "Failure";

		}

		if (actualResult.equals(Expectedresult)) {
			log.info("Login Test got passed");
		} else {
			log.error("Login Test got failed");
		}
	}

	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");

	}

	@DataProvider
	public Object[][] getLogindata() {
		Object[][] data = { { "pranay123@gmail.com", "123456", "Successfull" },
				{ "dummy123@gmail.com", "1234", "Failure" } };
		return data;

	}

}
