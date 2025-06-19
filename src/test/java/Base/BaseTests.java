package Base;

import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTests {
  @BeforeClass(alwaysRun = true)
  @Parameters("browser")
  public void setUp(@Optional("chrome") String browser) {
    WebDriver driver = DriverFactory.createDriver(browser);
    DriverManager.setDriver(driver);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
