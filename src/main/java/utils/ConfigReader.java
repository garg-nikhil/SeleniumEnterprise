package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
  private static Properties properties = new Properties();
  private static String configPath =
      System.getProperty("user.dir") + "/src/main/java/config/config.properties";

  static {
    try (FileInputStream fis = new FileInputStream(configPath)) {
      properties.load(fis);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}
