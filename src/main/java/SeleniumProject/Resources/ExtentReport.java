package SeleniumProject.Resources;

import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReport {

	public static ExtentReports getReportObject() {
		String Url = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(Url);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Web UI Report");

		ExtentReports et = new ExtentReports();
		et.attachReporter(reporter);
		et.setSystemInfo("Tester", "Rakesh");
		return et;

	}

}
