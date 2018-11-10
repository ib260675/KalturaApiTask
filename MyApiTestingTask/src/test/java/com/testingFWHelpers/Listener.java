package com.testingFWHelpers;

import org.testng.*;

public class Listener implements ITestListener {

    public void onTestStart(ITestResult arg0) {
        System.out.println("#########################   Current Test Class: " + arg0.getTestClass().getName() + "   ###########################################################################");
        System.out.println("#########################   starting test method: " + arg0.getName() + "   ###########################################################################");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext arg0) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}
