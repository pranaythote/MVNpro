package pageObject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage1 {

	WebDriver driver;

	public AccountPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(linkText="Edit your account information")
	WebElement editAccount;
	
	public WebElement editAccount() {
		return editAccount;
	}

	public WebElement editYourAccountInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
