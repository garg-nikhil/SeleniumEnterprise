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
  public void onTestSuccess(ITestResult result) {
    // long duration = result.getEndMillis() - result.getStartMillis();
    // InfluxDBLogger.logTestResult(result.getName(), "Pass", "Chrome", duration);
  }

  @Override
  public void onTestFailure(ITestResult result) {
    long duration = result.getEndMillis() - result.getStartMillis();
    // InfluxDBLogger.logTestResult(result.getName(), "Fail", "Chrome", duration);
  }

  @Override
  public void onTestSkipped(ITestResult result) {}

  @Override
  public void onFinish(ITestContext context) {}
}
