package Base;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
    private WebDriver driver;

    @BeforeClass
    public void setup(){
        driver =  DriverManager.getDriver();
    }

    @AfterClass
    public void tearDown(){
       DriverManager.quitDriver();
    }
}
