package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

public class DriverManager {
  ConfigReader config = new ConfigReader();

  private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  public static WebDriver getDriver() {
    if (driver.get() == null) {
      driver.set(createDriver());
    }
    return driver.get();
  }

  private static WebDriver createDriver() {
    // Add logic to support browser config from CLI or config file
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver1 = new ChromeDriver();
    driver1.manage().window().maximize();
    driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    //        File file = driver1.getScreenshotAs(OutputType.FILE);
    //        try {
    //            FileUtils.copyFile(file,new File("./Screenshots/abc.jpeg"));
    //        } catch (IOException e) {
    //            throw new RuntimeException(e);
    //        }
    return driver1;
  }

  public void remoteWebDriverDemo() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setBrowserName("chrome");
    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    driver.get("https://demoqa.com/");
    driver.findElement(By.xpath("//*[@alt='Selenium Online Training']"));
    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
  }

  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
  }
}
