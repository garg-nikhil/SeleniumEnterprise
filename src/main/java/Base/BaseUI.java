package Base;

import static io.restassured.RestAssured.given;

import driver.DriverManager;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BaseUI {

  WebDriver driver;

  public BaseUI() {
    this.driver = DriverManager.getDriver();
    PageFactory.initElements(driver, this);
  }

  public void scrollToElement(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true)", element);
  }

  public void takeScreenshot() throws IOException {
    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File("/screenshots/abc.jpeg"));
  }

  public void makePostCall() {
    String body = "Delis";
    Response response = given().headers("", "").body(body).when().post();
    int code = response.getStatusCode();
    if (code == 200) System.out.println("pass");
    else System.out.println("Fail");

    given().body(body).when().post().then().statusCode(200).contentType("application/json");
  }

  public void actionsDemoUsages() {
    Actions actions = new Actions(driver);
  }

  public void selectDemoUsages() {
    WebElement element = driver.findElement(By.xpath(""));
    Select select = new Select(element);
  }

  public void verifyElement(WebElement element) {}
}
