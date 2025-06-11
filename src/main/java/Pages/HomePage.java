package Pages;

import Base.BaseUI;
import driver.DriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

import static utils.ConfigReader.getProperty;

public class HomePage extends BaseUI {
    WebDriver driver;
    private static final Logger log = LoggerUtil.getLogger(HomePage.class);

    @FindBy(xpath = "//*[text()='Elements']")
    private WebElement ele;

    @FindBy(xpath = "//*[text()='Forms']")
    private WebElement forms;

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']")
    private WebElement alertsFramesWindowsBtn;

    @FindBy(xpath = "//*[@alt='Selenium Online Training']")
    private WebElement trainingBanner;

    @FindBy(xpath = "//*[contains(text(),'2013')]")
    private WebElement footer;

    public HomePage(){
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void launchPage(){
        String url = getProperty("baseUrl");
        driver.get(url);
        log.info("Navigated to: "+url);
        scrollToElement(ele);
    }

    public WebElement Elements(){
        return ele;
    }

    public WebElement getAlertsFramesWindows(){
        return alertsFramesWindowsBtn;
    }

    public WebElement getFormsBtn(){
        return forms;
    }

    public WebElement getBanner(){
        return trainingBanner;
    }

    public WebElement getFooter(){
        return footer;
    }

    public List<WebElement> getWebElements(){
        List<WebElement> elementsList = new ArrayList<>();
        elementsList.add(ele);
        elementsList.add(alertsFramesWindowsBtn);
        elementsList.add(forms);
        elementsList.add(trainingBanner);
        elementsList.get(1);
        return elementsList;
    }

}
