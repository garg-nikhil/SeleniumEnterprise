package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import utils.CapabilityFactory;

public class DriverFactory {

  public static WebDriver createDriver(String browser) {
    switch (browser.toLowerCase()) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver((ChromeDriverService) CapabilityFactory.getCapabilities("chrome"));

      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver((FirefoxOptions) CapabilityFactory.getCapabilities("firefox"));

      case "safari":
        SafariOptions safariOptions = new SafariOptions();
        return new SafariDriver(safariOptions);

      default:
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
  }
}
