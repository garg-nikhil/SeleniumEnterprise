package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverManager {
    ConfigReader config = new ConfigReader();

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {
        // Add logic to support browser config from CLI or config file
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        File file = driver1.getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(file,new File("./Screenshots/abc.jpeg"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        return driver1;
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

