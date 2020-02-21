package com.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class listeners extends ScreenShots  implements ITestListener {
   WebDriver driver;
   // ScreenShots sc = new ScreenShots();
    // These all methods implementsautomatically
    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test started :");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test Failure");
        //captureScreen1(result.getMethod().getMethodName());
        try {
            captureScreen1( driver,result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
