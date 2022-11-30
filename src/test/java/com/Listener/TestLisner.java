package com.Listener;

import java.io.IOException;

import com.facebook.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.Utility.UtilityClass;
import com.aventstack.extentreports.ExtentTest;

public class TestLisner extends BaseClass implements ITestListener {
    UtilityClass utility;
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " :onTestStart");
        extent.attachReporter(spark);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " :onTestSuccess");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Sirin").assignDevice("Chrome");
        test.pass("Test successfully executed");
        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " :onTestFailure");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Sirin").assignDevice("Chrome");
        test.fail("Test method failed");
        String fTname = result.getMethod().getMethodName();
        UtilityClass utility = new UtilityClass();
        utility.failedTest(fTname);
        test.addScreenCaptureFromPath("C:\\Users\\HP\\eclipse-workspace\\src\\test\\java\\Selenium\\PageObjectModel_Facebook\\FB.ScreenShots" + result.getMethod().getMethodName() + ".png");
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " :onTestSkipped");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.skip("Test method failed");
        extent.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " :onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(context);
    }

}