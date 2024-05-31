package main.java.utils.listners;

import main.java.utils.logUtility.LogToAllure;
import main.java.utils.logUtility.LogType;
import main.java.utils.logUtility.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {


    @Override
    public void onFinish(ITestContext Result) {

    }

    @Override
    public void onStart(ITestContext Result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LoggerFactory.getLogger(LogType.ALLURE_REPORT).log("The name of the testcase failed is :" + iTestResult.getName());
    }

    // When Test case get Skipped, this method is called.
    @Override
    public void onTestSkipped(ITestResult Result) {
        LoggerFactory.getLogger(LogType.ALLURE_REPORT).log("The name of the testcase Skipped is :" + Result.getName());
    }

    // When Test case get Started, this method is called.
    @Override
    public void onTestStart(ITestResult Result) {
        LoggerFactory.getLogger(LogType.ALLURE_REPORT).log("The name of the testcase started is :" + Result.getName());
    }

    // When Test case get passed, this method is called.
    @Override
    public void onTestSuccess(ITestResult Result) {
        LoggerFactory.getLogger(LogType.ALLURE_REPORT).log("The name of the testcase passed is :" + Result.getName());
    }

}
