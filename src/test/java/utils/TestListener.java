package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        // Optional: Start test logs here
    }

    @Override
    public void onTestSuccess(ITestResult result){
        long duration = result.getEndMillis() - result.getStartMillis();
        InfluxDBLogger.logTestResult(result.getTestName(), "Pass",duration, result.getHost(), result.getInstance(), result.getInstanceName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        long duration = result.getEndMillis() - result.getStartMillis();
        InfluxDBLogger.logTestResult(result.getTestName(), "Fail",duration, result.getHost(), result.getInstance(), result.getInstanceName());
    }

    @Override
    public void onTestSkipped(ITestResult result){

    }

    @Override
    public void onFinish(ITestContext context){

    }
}
