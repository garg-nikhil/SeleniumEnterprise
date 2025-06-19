package AI.POC;

import com.epam.healenium.SelfHealingDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Healenium {

  //        private WebDriver baseDriver;
  //        private SelfHealingDriver driver;
  // private Eyes eyes;

  /**
   * This method sets up the WebDriver and Applitools Eyes instance. It initializes the ChromeDriver
   * and configures the Eyes instance with the API key.
   */
  @Test
  public void setup() {
    WebDriverManager.chromedriver().setup();
    WebDriver delegate = new ChromeDriver();
    SelfHealingDriver driver = SelfHealingDriver.create(delegate);
    driver.manage().window().maximize();
    driver.get("http://localhost:8080/login.html");
    driver.findElement(By.xpath("//*[@id='login-button']")).click();
    // Break the DOM ID so healing is required
    ((JavascriptExecutor) driver)
        .executeScript("document.getElementById('login-button').id = 'login-btn';");

    // Same selector in code
    driver.findElement(By.id("login-button")).click();
    System.out.println(driver.getTitle());

    //            eyes = new Eyes();
    //            eyes.setApiKey("hPoz5nQgaG2108ghNRk4KNfKBLj107Rq4NcWB5Im7MgjeLE110");

  }

  @Test
  public void remoteWebDriverDemo() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setBrowserName("chrome");
    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
    driver.get("https://demoqa.com/");
    driver.findElement(By.xpath("//*[@alt='Selenium Online Training']"));
    System.out.println(driver.getTitle());
    System.out.println(driver.getCurrentUrl());
  }

  /**
   * This test checks the visual and functional aspects of the home page. It opens the page, clicks
   * a button, and verifies the visual state after the action.
   */

  /* public void testHomePageVisualAndFunctional() {
     // eyes.open(driver, "Demo App", "Home Page Test", new RectangleSize(1200, 800));
      driver.get("https://example.com");

      driver.findElement(By.xpath("//button[@id='submit']")).click();
      //eyes.checkWindow("After Submit");
      eyes.close();
  }

  public void tearDown() {
      eyes.abortIfNotClosed();
      driver.quit();
  }*/
}
