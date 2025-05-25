package Pages;

import Base.BaseUI;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseUI {
    WebDriver driver;

    @FindBy(xpath = "//*[text()='Elements']")
    private WebElement ele;

    @FindBy(xpath = "//*[text()='Text Box']")
    private WebElement textBoxBtn;

    @FindBy(xpath = "//*[text()='Forms']")
    private WebElement forms;

    public HomePage(){
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void launchPage(){
        driver.get("https://demoqa.com/");
    }

    public void element(){
        scrollToElement(ele);
        ele.isDisplayed();
        forms.isDisplayed();
    }

}
