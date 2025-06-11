package Base;

import driver.DriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import utils.LoggerUtil;

public class BaseTests {
    private WebDriver driver;
    private final SoftAssert softAssert = new SoftAssert();
    private static final Logger log = LoggerUtil.getLogger(BaseTests.class);

    @BeforeClass
    public void setup(){
        driver =  DriverManager.getDriver();
    }

    @AfterClass
    public void tearDown(){
       //DriverManager.quitDriver();
    }

    public void verifyElement(WebElement element, String elementName, boolean checkEnabled){
        try {
            softAssert.assertTrue(element.isDisplayed(), elementName+ " is not displayed");
            if(checkEnabled){
                softAssert.assertTrue(element.isEnabled(), elementName + " is not enabled");
            }
            log.info("Verified: " +elementName);
        }
        catch(Exception e){
            log.error("Error while verifying the element: "+elementName, e);
            softAssert.fail("Assertion failed while verifying: "+elementName+" "+e.getMessage());
        }
    }
}
