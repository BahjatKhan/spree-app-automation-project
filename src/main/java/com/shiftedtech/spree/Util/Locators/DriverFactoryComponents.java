package com.shiftedtech.spree.Util.Locators;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
class DriverFactoryComponents {

    protected static WebDriver driver;
    protected static ThreadLocal<WebDriver> driverCollection = new ThreadLocal<WebDriver>();
    protected static DesiredCapabilities caps = new DesiredCapabilities();

    protected static final String LOCAL_GRID_URL = "http://selenium-hub.shiftedtech.com/wd/hub";

    protected static final String USERNAME = "bahjatkhan1";
    protected static final String AUTOMATE_KEY = "TbVWMFj8YNcEMSkvwoqt";
    protected static final String CLOUD_GRID_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    protected static void getFireFox() {
        FirefoxDriverManager.firefoxdriver().arch64().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", true);

        driver = new FirefoxDriver(options);
    }

    protected static void getChrome() {
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    protected static void getChromeHeadless() {
        ChromeDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless")
                .addArguments("--disable-gpu")
                .addArguments("--window-size=1920,1080")
                .addArguments("--ignore-certificate-errors");

        //options.setBinary("/Path/to/specific/version/of/Google Chrome");
        driver = new ChromeDriver(options);
    }

    protected static void getFireFoxGrid() {

        caps.setPlatform(Platform.ANY);
        caps.setBrowserName("firefox");
        try {
            driver = new RemoteWebDriver(new URL(LOCAL_GRID_URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //FirefoxOptions options = new FirefoxOptions();
        //options.setCapability("marionette", true);
        //driver = new FirefoxDriver(options);
    }


    protected static void getChromeGrid() {

        caps.setPlatform(Platform.ANY);
        caps.setBrowserName("chrome");
        try {
            driver = new RemoteWebDriver(new URL(LOCAL_GRID_URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    protected static void getFireFoxCloud() {

        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "70.0");
        getCloudWindowsOsSetting();
    }

    protected static void getChromeCloud() {

        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "77.0");
        getCloudWindowsOsSetting();
    }

    public static WebDriver getDriver() {
        return driverCollection.get();
    }

    public static void removeDriver() {
        // Quits the driver and closes the browser
        try {
            driverCollection.get().close();
            driverCollection.get().quit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            driverCollection.remove();
        }


    }
    private static void getCloudWindowsOsSetting(){
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("name", "Cloud-Browser");
        try {
            driver = new RemoteWebDriver(new URL(CLOUD_GRID_URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}








