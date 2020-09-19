package com.shiftedtech.spreeTest;

import com.shiftedtech.spree.FunctionalMethods;
import com.shiftedtech.spree.pom.ApplicationController;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;

public class SetupGrid extends FunctionalMethods {

    ThreadLocal<WebDriver> driverCollection= new ThreadLocal<>();
    ThreadLocal<ApplicationController> spreeCollection=new ThreadLocal<>();

    private String LOCAL_GRID_URL="http://192.168.1.6:4444/wd/hub";

    public static final String USERNAME = "bahjat1";
    public static final String AUTOMATE_KEY = "eQektnT1edpaRVQxJxh9";
    public static final String CLOUD_GRID_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Before
    public void setup() throws MalformedURLException {
        WebDriver driver ;


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "79.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        driver=new RemoteWebDriver(new URL(CLOUD_GRID_URL),caps);

        driverCollection.set(driver);
//        DesiredCapabilities caps =new DesiredCapabilities();
//        caps.setPlatform(Platform.ANY);
//        caps.setBrowserName("chrome");driver=new RemoteWebDriver(new URL(LOAD_LOCAL_GRID),caps);

      //  driverCollection.set(driver);
        driverCollection.get().navigate().to("http://spree.shiftedtech.com");

        ApplicationController spree =new ApplicationController(driverCollection.get());

        spreeCollection.set(spree);

//        spreeCollection.set(new ApplicationController(driverCollection.get()));




    }
    @After
    public void tearDown(){
        driverCollection.get().close();
        driverCollection.get().quit();

        spreeCollection.remove();

    }


    public ApplicationController spree(){

        return spreeCollection.get();
    }

    public WebDriver driver(){
        return driverCollection.get();
    }




}
