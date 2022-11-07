package test1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resoureces.Base1;

public class ThirdTest extends Base1 {
	public WebDriver driver;
	@Test
	public void Testthree() throws IOException, InterruptedException {

		System.out.println("Test Three Run");

		driver = intializeBrowser();

		driver.get("http://tutorialsninja.com/demo/");

		Thread.sleep(2000);
		driver.close();

	}

}
