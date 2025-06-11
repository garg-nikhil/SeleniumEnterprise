package config;

public class ConfigConstants {
  // Execution modes
  public static final String EXECUTION_MODE_LOCAL = "local";
  public static final String EXECUTION_MODE_REMOTE = "remote";

  // Browsers
  public static final String BROWSER_CHROME = "chrome";
  public static final String BROWSER_FIREFOX = "firefox";
  public static final String BROWSER_SAFARI = "safari";
  public static final String BROWSER_ALL = "all";

  // Mobile Devices
  public static final String MOBILE_ANDROID = "android";
  public static final String MOBILE_IOS = "ios";
  public static final String MOBILE_ALL = "all";

  // Environment variables keys
  public static final String ENV_EMAIL_USER = "EMAIL_USER";
  public static final String ENV_EMAIL_PASS = "EMAIL_PASSWORD";

  // Others
  public static final String GRAFANA_DASHBOARD_URL = "http://localhost:3000/d/your_dashboard_id";
  public static final String INFLUX_DB_URL = "http://localhost:8086";
}
