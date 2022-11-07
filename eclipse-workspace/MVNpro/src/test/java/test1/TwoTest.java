package test1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resoureces.Base1;

public class TwoTest extends Base1 {
	public WebDriver driver;

	@Test
	public void Testtwo() throws IOException, InterruptedException {

		System.out.println("Test Two Run");

		WebDriver driver = intializeBrowser();

		driver.get("http://tutorialsninja.com/demo/");

		Thread.sleep(2000);
		driver.close();
	}

}
