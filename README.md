UML Class Diagram: 

+------------------+
|  FrameworkConfig |
|------------------|
| +browser()       |
| +mode()          |
| +baseUrl()       |
+--------^---------+
|
|
|
+--------+----------+
|   ConfigFactory   |
|-------------------|
| +getConfig()      |
+--------^----------+
|
|
|
+--------+----------+       +-------------------+
|     DriverFactory |<------+  WebDriverManager |
|-------------------|       |-------------------|
| +initializeDriver()       | +setDriver()      |
| +getChromeOptions()       | +getDriver()      |
| +getRemoteDriver()        | +unloadDriver()   |
+------------+--------------+-------------------+
|
|
v
+----------------+
| ChromeDriver   |
| FirefoxDriver  |
| RemoteWebDriver|
+----------------+


Execution Flow

mvn test -Dbrowser=chrome -Dmode=grid
│
▼
[ConfigFactory.getConfig()]
│
▼
[DriverFactory.initializeDriver()]
│
├──► Local: new ChromeDriver()
│
└──► Grid: new RemoteWebDriver(URL, Capabilities)
│
▼
[WebDriverManager.setDriver(driver)]
│
▼
[Test Classes use WebDriverManager.getDriver()]

Visual Dependency Flow (Execution Lifecycle)

TestNG Runner (xml) ──▶ BaseTest
│
▼
setup() in @BeforeClass
│
▼
DriverFactory.initializeDriver()
│
▼
WebDriverManager.setDriver(driverInstance)
│
▼
Page Objects use getDriver()
│
▼
teardown() in @AfterClass
│
▼
WebDriverManager.unloadDriver()
