package utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariOptions;

public class CapabilityFactory {

        public static Capabilities getCapabilities(String browser) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    return getChromeCapabilities();

                case "firefox":
                    return getFirefoxCapabilities();

                case "edge":
                    return getEdgeCapabilities();

                case "safari":
                    return getSafariCapabilities();

                default:
                    throw new WebDriverException("Unsupported browser: " + browser);
            }
        }

        private static Capabilities getChromeCapabilities() {
            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
            options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            options.setAcceptInsecureCerts(true);
            return options;
        }

        private static Capabilities getFirefoxCapabilities() {
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
            options.setCapability(CapabilityType.BROWSER_NAME, "firefox");
            options.setAcceptInsecureCerts(true);
            return options;
        }

        private static Capabilities getEdgeCapabilities() {
            EdgeOptions options = new EdgeOptions();
            options.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
            options.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
            options.setAcceptInsecureCerts(true);
            return options;
        }

        private static Capabilities getSafariCapabilities() {

            SafariOptions options = new SafariOptions();
            options.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
            options.setCapability(CapabilityType.BROWSER_NAME, "safari");
            options.setAcceptInsecureCerts(true);
            return options;
        }

}
