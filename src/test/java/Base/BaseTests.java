package Base;

import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import utils.LoggerUtil;

public class BaseTests {
  private WebDriver driver;
  private final SoftAssert softAssert = new SoftAssert();
  private static final Logger log = LoggerUtil.getLogger(BaseTests.class);

  public BaseTests() {}

  //@BeforeClass
  public void setup() {
    WebDriverManager.chromedriver().setup();
/*
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    options.addArguments("--remote-allow-origins=*");

    // ✅ Fix: Use unique user-data-dir to avoid profile conflict
    options.addArguments("--user-data-dir=/tmp/profile-" + System.currentTimeMillis());
*/

    driver = new ChromeDriver();
    //DriverManager.setDriver(driver);
    //driver = DriverManager.getDriver();
  }

  //@AfterClass
  public void tearDown() {
    DriverManager.quitDriver();
  }

  public void verifyElement(WebElement element, String elementName, boolean checkEnabled) {
    try {
      softAssert.assertTrue(element.isDisplayed(), elementName + " is not displayed");
      if (checkEnabled) {
        softAssert.assertTrue(element.isEnabled(), elementName + " is not enabled");
      }
      log.info("Verified: " + elementName);
    } catch (Exception e) {
      log.error("Error while verifying the element: " + elementName, e);
      softAssert.fail("Assertion failed while verifying: " + elementName + " " + e.getMessage());
    }
  }
}
