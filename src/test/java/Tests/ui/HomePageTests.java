package Tests.ui;

import Base.BaseTests;
import Base.BaseUI;
import Pages.HomePage;
import driver.DriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.LoggerUtil;

import static utils.ConfigReader.getProperty;

public class HomePageTests extends BaseTests {
    HomePage homePage = new HomePage();
    private static final Logger log = LoggerUtil.getLogger(HomePageTests.class);
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver;

    public HomePageTests(){
        this.driver = DriverManager.getDriver();
    }

    @Test
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
}
