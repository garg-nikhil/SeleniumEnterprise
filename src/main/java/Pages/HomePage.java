package Pages;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "")
    private WebElement ele;

    @FindBy(xpath = "")
    private WebElement home;

    @FindBy(xpath = "")
    private WebElement base;

    public HomePage(){
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void launchPage(){
        driver.get("https://demoqa.com/");
    }

}
