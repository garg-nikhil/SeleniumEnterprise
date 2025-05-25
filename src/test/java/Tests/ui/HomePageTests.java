package Tests.ui;

import Base.BaseTests;
import Pages.HomePage;
import driver.DriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

        verifyElementsBtn();
        verifyAlertsFramesWindowsBtn();
        verifyFormsButton();
        verifyBanner();
        verifyFooter();
        softAssert.assertAll();
    }


    private void verifyElementsBtn(){
        homePage.element();
        WebElement elements = homePage.Elements();
        softAssert.assertTrue(elements.isDisplayed(),"Elements is not displaying");
        softAssert.assertTrue(elements.isEnabled(),"Elements is not enabled");
        log.info("Verifying element button");
    }

    private void verifyAlertsFramesWindowsBtn(){
        WebElement alertsBtn = homePage.getAlertsFramesWindows();
        softAssert.assertTrue(alertsBtn.isDisplayed(),"Alerts, Frame & Windows button is not displayed");
        softAssert.assertTrue(alertsBtn.isEnabled(), "Alerts, Frame & Windows button is not enabled");
        log.info("Verifying alerts frames button");
    }

    private void verifyFormsButton(){
        WebElement formsBtn = homePage.getFormsBtn();
        softAssert.assertTrue(formsBtn.isDisplayed(), "Forms button is not displayed");
        softAssert.assertTrue(formsBtn.isEnabled(), "Forms button is not enabled");
        log.info("Verifying forms button");
    }

    private void verifyBanner(){
        WebElement banner = homePage.getBanner();
        softAssert.assertTrue(banner.isDisplayed(), "Welcome banner is not displayed");
        log.info("Verifying banner");
    }

    private void verifyFooter(){
        WebElement footer = homePage.getFooter();
        softAssert.assertTrue(footer.isDisplayed(), "Footer is not displayed");
        softAssert.assertEquals(footer.getText(),"© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.");
        log.info("verifying footer");
    }

    private void verifyAllElements(){
        homePage.getWebElements();
    }
}
