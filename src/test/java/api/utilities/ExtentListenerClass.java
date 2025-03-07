package api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListenerClass implements ITestListener {

    private static ExtentReports reports;
    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        configureReport();
        LoggerUtils.info("Test Suite started: " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        test = reports.createTest(testName)
                .info(description != null ? "**Description:** " + description : "No description provided");
        LoggerUtils.info("Test Started: " + testName + (description != null ? " - " + description : ""));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        test.pass("**Test Passed:** " + testName);
        logParameters(result);
        LoggerUtils.info("Test Passed: " + testName);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();

        // Log failure message and exception
        test.fail("**Test Failed:** " + testName + (description != null ? " - " + description : ""));
        test.fail(result.getThrowable());  // Log exception (stack trace)

        logParameters(result);
        LoggerUtils.error("Test Failed: " + testName + (description != null ? " - " + description : ""), result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription();
        test.skip("**Test Skipped:** " + testName)
                .info(description != null ? "**Description:** " + description : "No description provided");
        logParameters(result);
        LoggerUtils.warn("Test Skipped: " + testName + (description != null ? " - " + description : ""));
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
        LoggerUtils.info("Test Suite finished: " + context.getName());
    }

    private void configureReport() {
        String timestamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/Reports/";
        new File(reportPath).mkdirs(); // Ensure directory exists
        String reportName = "API_Automation_Report_" + timestamp + ".html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath + reportName);
        htmlReporter.config().setDocumentTitle("API Automation Report");
        htmlReporter.config().setReportName("API Test Execution");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimelineEnabled(true);

        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        reports.setSystemInfo("Machine", System.getenv("COMPUTERNAME"));
        reports.setSystemInfo("OS", System.getProperty("os.name"));
        reports.setSystemInfo("Tester", "Atif Khan");

        Runtime.getRuntime().addShutdownHook(new Thread(this::finalizeReport));
    }

    private void finalizeReport() {
        if (reports != null) {
            reports.flush();
            System.out.println("Finalizing report and flushing data.");
        }
    }

    /**
     * Logs only Parameter 4 and test status.
     *
     * @param result The result object containing test parameters.
     */
    private void logParameters(ITestResult result) {
        Object[] parameters = result.getParameters();
        if (parameters != null && parameters.length >= 4) {
            // Log only Parameter 4
            test.info("**Parameter 4:** " + parameters[3]);

            // Log test status
            if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("**Status:** Pass");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                test.fail("**Status:** Fail");
            } else {
                test.skip("**Status:** Skipped");
            }
        } else {
            test.info("**Parameter 4:** Not available");
        }
    }
}
