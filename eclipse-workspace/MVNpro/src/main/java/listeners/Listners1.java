package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resoureces.Base1;
import utilities.ExtentReporter;

//ITestListener some times not in selenium so hover the mous in ItestListener and click fixed the project 
// Afte that import import org.testng.ITestListener;
//then Go to source option from your tool bar and click Override/impliment method
//and select all testNG method

// Make ExtentReports thread-safe, by adding this code to Listeners class

public class Listners1 extends Base1 implements ITestListener {

	WebDriver driver;
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;

	// adding this line for thread-safe
	// we make that line because if we do not add this line then parallel exicution
	// are not run without adding this line
	// so for thread safe we have to write proper code in that way

	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getName();

		extentTest = extentReport.createTest(testName + "Exicution Started");
		extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String Testname = result.getName();
		// extentTest.log(Status.PASS,Testname+ "got passed");
		extentTestThread.get().log(Status.PASS, Testname + "got passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String TestMethodName = result.getName();
		// extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String screenshotFilePath = ScreenShot(TestMethodName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, TestMethodName);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();

	}

}
