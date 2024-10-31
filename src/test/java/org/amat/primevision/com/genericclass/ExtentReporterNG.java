package org.amat.primevision.com.genericclass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentReporterNG  {

static String htmlReportPath;

    public static ExtentReports getReportObject() {


		convertDateToString();
		//System.out.println("path of the html report --> "+htmlReportPath);

		ExtentSparkReporter reporter = new ExtentSparkReporter(htmlReportPath);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nitin AC");

		return extent;
		
		
		
	}

	private static void convertDateToString() {
		String dateTime = getDateTime("dd-MM-YYYY hh:m:ss a");

		String[] dateArray=dateTime.split(" ");
		String[] splitTime =dateArray[1].split(":");
		String time=splitTime[0]+"-"+splitTime[1]+"-"+splitTime[2];
		String resultMainFolder = System.getProperty("user.dir") + "\\Reports\\DetailedReport\\Results_" + getDateTime("dd-MM-YY");
		File resultFolder = new File(resultMainFolder);
		if ((!resultFolder.exists())) resultFolder.mkdir();

		System.setProperty("htmlReportPath", resultFolder + "\\Results_Date-" + getDateTime("dd-MM-YYYY") +"-Time-"+ time + "\\FinalReport.html");
		htmlReportPath = System.getProperty("htmlReportPath");
	}

	public static String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		String ScreenShotPath = htmlReportPath.substring(0, htmlReportPath.indexOf("FinalReport"));
		ScreenShotPath=ScreenShotPath+"FailedScenarioScreenShots\\" + testCaseName + ".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(ScreenShotPath);
		FileUtils.copyFile(source, file);
		return ScreenShotPath;


	}


	/*************************************
	 * Method Name			: getDataTime
	 * Purpose				:
	 * Parameter			:
	 * Author				: user1
	 * ***********************************
	 */
	public static String getDateTime(String strDateFormat) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		return dateFormat.format(date);
	}


}
