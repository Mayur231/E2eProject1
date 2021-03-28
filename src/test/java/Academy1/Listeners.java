package Academy1;


import Academy.Resources.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterNG;

import java.io.IOException;

//ITestListener interface which implements Testng listeners
public class Listeners extends Base implements ITestListener {
ExtentTest test;
ThreadLocal<ExtentTest> Extenttest=new ThreadLocal<ExtentTest>();
ExtentReports extent=ExtentReporterNG.getReportObject();

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
         test=extent.createTest(result.getMethod().getMethodName());
         Extenttest.set(test);

    }


    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
Extenttest.get().log(Status.PASS,"Test passed");

    }


    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        //screenshot code
        Extenttest.get().fail(result.getThrowable());
        WebDriver driver =null;
        String testMethodName = result.getMethod().getMethodName();
        try
        {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        }
        catch(Exception e)
        {

        }
       try
        {
            Extenttest.get().addScreenCaptureFromPath( getScreenShotpath(testMethodName,driver),result.getMethod().getMethodName());

        }
       catch (IOException e)
       {
           e.printStackTrace();
       }
       }


    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }


    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }


    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        extent.flush();

    }

}

