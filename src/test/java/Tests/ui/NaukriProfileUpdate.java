package Tests.ui;

import Base.BaseTests;
import driver.DriverManager;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NaukriProfileUpdate extends BaseTests {
    WebDriver driver;

    NaukriProfileUpdate(){
        this.driver = DriverManager.getDriver();
    }

    @Test
    public void UpdateNaukriProfile(){
        driver.get("https://login.naukri.com/nLogin/Login.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        String label = "I'm Feeling Lucky";
//        String x = "//*[@aria-label="+label+"][1]";
        driver.findElement(By.xpath("//*[@id='usernameField']")).sendKeys("nikhilgarg855@gmail.com");
        driver.findElement(By.xpath("//*[@id='passwordField']")).sendKeys("Sons@1234");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        driver.findElement(By.xpath("//*[text()='View']")).click();
        driver.findElement(By.xpath("//*[text()='Resume headline']/following-sibling::span[text()='editOneTheme']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Save']")));
        driver.findElement(By.xpath("//*[text()='Save']")).click();

    }
}
