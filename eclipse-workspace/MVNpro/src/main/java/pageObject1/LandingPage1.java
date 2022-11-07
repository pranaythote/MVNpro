package pageObject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage1 {
	WebDriver driver;

	public LandingPage1(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@title='My Account']")
	WebElement MyaccountDropDown;

	@FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	WebElement LoginOption;

	public WebElement MyaccountDropDown() {
		return MyaccountDropDown;
	}

	public WebElement LoginOption() {
		return LoginOption;
	}

}
