package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class DriverFactory {

  public static WebDriver createDriver(String browser) {
    switch (browser.toLowerCase()) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        return new ChromeDriver(chromeOptions);

      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--width=1920", "--height=1080");
        return new FirefoxDriver(firefoxOptions);

      case "safari":
        SafariOptions safariOptions = new SafariOptions();
        return new SafariDriver(safariOptions);

      default:
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
  }
}
