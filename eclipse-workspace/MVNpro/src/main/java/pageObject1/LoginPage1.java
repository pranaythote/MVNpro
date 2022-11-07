package pageObject1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {

	WebDriver driver;

	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='input-email']") //  for encapsulation we just all the webelement as private
	private WebElement emailid;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordFild;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement LoginField;
	
	public WebElement emailid() {
		return emailid;
	}
	
	public WebElement passwordFild() {
		return passwordFild;
	}
	
	public WebElement LoginField() {
		return LoginField;
	}

	public WebElement emailAddressTextField() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement loginButton() {
		// TODO Auto-generated method stub
		return null;
	}
}


