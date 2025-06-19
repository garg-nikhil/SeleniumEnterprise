package Pages;

import driver.DriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.PasswordEncryptor;

public class NaukriPortal {
  private WebDriver driver;

  @FindBy(xpath = "//*[@id='usernameField']")
  private WebElement usernameField;

  @FindBy(xpath = "//*[@id='passwordField']")
  private WebElement passwordField;

  @FindBy(xpath = "//button[text()='Login']")
  private WebElement loginButton;

  @FindBy(xpath = "//*[text()='View']")
  private WebElement viewButton;

  @FindBy(xpath = "//*[text()='Resume headline']/following-sibling::span[text()='editOneTheme']")
  private WebElement editResumeHeadlineButton;

  @FindBy(xpath = "//*[text()='Save']")
  private WebElement saveButton;

  public NaukriPortal() {
    this.driver = DriverManager.getDriver();
    PageFactory.initElements(driver, this);
  }

  public void launchAndUpdateNaukriPortal() {
    driver.get("https://login.naukri.com/nLogin/Login.php");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    usernameField.sendKeys("nikhilgarg855@gmail.com");
    passwordField.sendKeys(PasswordEncryptor.decrypt(ConfigReader.getProperty("NaukriPassword")));
    loginButton.click();
    viewButton.click();
    editResumeHeadlineButton.click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    saveButton.click();
  }
}
