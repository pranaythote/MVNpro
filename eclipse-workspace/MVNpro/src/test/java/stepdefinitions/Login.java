package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject1.AccountPage1;
import pageObject1.LandingPage1;
import pageObject1.LoginPage1;
import resoureces.Base1;

public class Login extends Base1 {

	WebDriver driver;
	LandingPage1 landingpage;
	LoginPage1 login;
	AccountPage1 accountPage;

	@Given("^ Open any Browser$")
	public void Open_any_Browser() throws IOException {

		driver = intializeBrowser();

	}

	@And("^Navigate to Login page$")
	public void Navigate_to_Login_page() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		landingpage = new LandingPage1(driver);
		landingpage.MyaccountDropDown().click();
		landingpage.LoginOption().click();

		Thread.sleep(2000);

	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String email,
			String password) {

		login = new LoginPage1(driver);
		login.emailid().sendKeys(email);
		login.passwordFild().sendKeys(password);
	}

	@And("^User clicks on Login button$")
	public void User_clicks_on_Login_button() {

		landingpage.LoginOption().click();

	}

	@Then("^Verify user is able to successfully login$")
	public void Verify_user_is_able_to_successfully_login() {

		accountPage = new AccountPage1(driver);
		Assert.assertTrue(accountPage.editAccount().isDisplayed());

	}

	@After
	public void closeBrowser() {
		driver.close();
	}

}
