//package driver;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.ios.IOSDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class MobileDriverFactory {
//
//    private static ThreadLocal<Object> driver = new ThreadLocal<>();
//
//    public static Object getDriver(String platform, boolean useRealDevice) throws MalformedURLException {
//        if (driver.get() == null) {
//            driver.set(createDriver(platform, useRealDevice));
//        }
//        return driver.get();
//    }
//
//    private static Object createDriver(String platform, boolean useRealDevice) throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//
//        if ("android".equalsIgnoreCase(platform)) {
//            caps.setCapability("platformName", "Android");
//            if (useRealDevice) {
//                caps.setCapability("udid", System.getenv("ANDROID_UDID")); // real device id
//            } else {
//                caps.setCapability("avd", "Nexus_5_API_30"); // emulator name
//            }
//            caps.setCapability("appPackage", "com.example.app");
//            caps.setCapability("appActivity", "com.example.app.MainActivity");
//
//            return new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
//        } else if ("ios".equalsIgnoreCase(platform)) {
//            caps.setCapability("platformName", "iOS");
//            if (useRealDevice) {
//                caps.setCapability("udid", System.getenv("IOS_UDID"));
//            } else {
//                caps.setCapability("deviceName", "iPhone Simulator");
//            }
//            caps.setCapability("bundleId", "com.example.app");
//
//            return new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
//        }
//        throw new IllegalArgumentException("Unsupported platform: " + platform);
//    }
//
//    public static void quitDriver() {
//        if (driver.get() != null) {
//            if (driver.get() instanceof AndroidDriver) {
//                ((AndroidDriver<?>) driver.get()).quit();
//            } else if (driver.get() instanceof IOSDriver) {
//                ((IOSDriver<?>) driver.get()).quit();
//            }
//            driver.remove();
//        }
//    }
//}
//
