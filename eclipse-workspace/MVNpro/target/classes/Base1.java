package resoureces;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base1 {

	WebDriver driver;
	public Properties prop;

	public WebDriver intializeBrowser() throws IOException { 

		prop = new Properties();
		String propertyPath = System.getProperty("user.dir") + "\\src\\main\\java\\resoureces\\data.properties";
		FileInputStream fis = new FileInputStream(propertyPath);
		prop.load(fis);

		String BrowserName = "chrome";
		if (BrowserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (BrowserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (BrowserName.equalsIgnoreCase("IE")) {

			WebDriverManager.iedriver().setup();
			WebDriver driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String ScreenShot(String testMethodName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\Screenshot\\"+testMethodName+".png";
		FileUtils.copyFile(SourceFile, new File(destinationPath));
		return destinationPath;
				
	}
	
}


