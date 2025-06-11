package Base;

import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import utils.LoggerUtil;

public class BaseTests {
  private WebDriver driver;
  private final SoftAssert softAssert = new SoftAssert();
  private static final Logger log = LoggerUtil.getLogger(BaseTests.class);

  public BaseTests() {}

  @BeforeClass
  public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    //driver = DriverManager.getDriver();
  }

  @AfterClass
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
