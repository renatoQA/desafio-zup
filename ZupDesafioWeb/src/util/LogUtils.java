package util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class LogUtils {

	private static ExtentTest uniqueInstance;
	private final static String REPORT_PATH = "\\Reports\\extentReportFile.html";
	private final static String TITLE = "Challenge2020";
	static ExtentReports extent;
	static ExtentTest extentTest;
	static String extentReportFile;

	private LogUtils() {
	}

	public static synchronized void log(LogStatus status, String message) {
		if (uniqueInstance == null) {
			initLog();
		}
		uniqueInstance.log(status, message);

	}
	
	private static void initLog() {
		extentReportFile = System.getProperty("user.dir") + REPORT_PATH;
		extent = new ExtentReports(extentReportFile, false);
		uniqueInstance = extent.startTest(TITLE, TITLE);		
	}

	public static void finishLog() {
		if (extent != null) {
			extent.endTest(extentTest);
			extent.flush();
		}
	}
}