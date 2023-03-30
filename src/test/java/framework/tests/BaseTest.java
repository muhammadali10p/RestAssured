package framework.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.api.helper.PersonServiceHelper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    public static PersonServiceHelper personServiceHelper;
    static ExtentTest test;
    static ExtentReports report;

    @BeforeSuite
    public void init()
    {
        try {
            personServiceHelper = new PersonServiceHelper();
            report = new ExtentReports();
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
            report.attachReporter(htmlReporter);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown()
    {
        report.flush();
    }


}
