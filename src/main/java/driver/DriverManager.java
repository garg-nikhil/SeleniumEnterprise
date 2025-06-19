package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    if (driver.get() == null) {
      throw new IllegalStateException(
          "WebDriver is not initialized. Did you call DriverManager.setDriver()?");
    }
    return driver.get();
  }

  public static void setDriver(WebDriver driverInstance) {
    driver.set(driverInstance);
  }

  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
