package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extentReport;

	public static ExtentReports getExtentReport() {

		String ExtentReportPath = System.getProperty("user.dir") + "\\reports\\extentreports.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(ExtentReportPath);
		reporter.config().setReportName("Tutorialninja automation tutorial");
		reporter.config().setDocumentTitle("Test Result");

		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System", "Windows 7");
		extentReport.setSystemInfo("Tested By", "Pranay Thote");
		return extentReport;

	}

}
