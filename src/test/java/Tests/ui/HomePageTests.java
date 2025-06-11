package Tests.ui;

import Base.BaseTests;
import Base.BaseUI;
import Pages.HomePage;
import driver.DriverManager;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.LoggerUtil;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.ConfigReader.getProperty;

public class HomePageTests extends BaseTests {
    HomePage homePage = new HomePage();
    private static final Logger log = LoggerUtil.getLogger(HomePageTests.class);
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;

    public HomePageTests(){
        this.driver = DriverManager.getDriver();
    }

   // @Test
    public void verifyActionsOnHomePage(){
        homePage.launchPage();
        softAssert.assertEquals(driver.getCurrentUrl(),getProperty("baseUrl"));
        softAssert.assertEquals(driver.getTitle(),"DEMOQA");
        verifyElement(homePage.Elements(),"elements", true);
        verifyElement(homePage.getAlertsFramesWindows(), "Alerts, Frame & Windows button", true);
        verifyElement(homePage.getFormsBtn(), "Forms", true);
        verifyElement(homePage.getBanner(), "Banner", false);
        verifyElement(homePage.getFooter(), "Footer", false);
        softAssert.assertAll();
    }

    //@Test
    public void amazonIphone(){
        driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone 15 pro max");

        List<WebElement> suggesttionList = driver.findElements(By.xpath("//*[@class='s-suggestion s-suggestion-ellipsis-direction']"));

       // for(WebElement )
    }
    //@Test
    public void makeMyTrip(){
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@data-cy='closeModal']")).click();
        WebElement dates = driver.findElement(By.xpath("//*[@data-cy='departureDate']"));
        log.info(dates.getText());
        String[] temp = dates.getText().split(" ");
        String date = temp[0];
        //temp[0].replace();
        //int a = temp[0];
        driver.findElement(By.xpath("//*[text()='Departure']")).click();
        driver.findElement(By.xpath("//*[@class='dateInnerCell']/child::p[text()="+date+"]")).click();

        //00005
    }

    @Test
    public void lucky(){
        driver.get("https://login.naukri.com/nLogin/Login.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        String label = "I'm Feeling Lucky";
//        String x = "//*[@aria-label="+label+"][1]";
        driver.findElement(By.xpath("//*[@id='usernameField']")).sendKeys("nikhilgarg855@gmail.com");
        driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("Sons@1234");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        driver.findElement(By.xpath("//*[text()='View']")).click();
        driver.findElement(By.xpath("//*[text()='Resume headline']/following-sibling::span[text()='editOneTheme']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[text()='Save']")).click();

    }

    public void rest(){
    String payload = "{\n" +
            "    \"name\": \"Apple MacBook Pro 16\",\n" +
            "    \"data\": {\n" +
            "        \"year\": 2019,\n" +
            "        \"price\": 1849.99,\n" +
            "        \"CPU model\": \"Intel Core i9\",\n" +
            "        \"Hard disk size\": \"1 TB\"\n" +
            "    }\n" +
            "}";
        Response reponse = given().contentType("application/json").log().all().baseUri("https://api.restful-api.dev/objects").body(payload).when().post();
        log.info(reponse.asPrettyString());
    }


}
