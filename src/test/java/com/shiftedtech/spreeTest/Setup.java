package com .shiftedtech.spreeTest;

import com.shiftedtech.spree.FunctionalMethods;
import com.shiftedtech.spree.Util.Locators.DriverFactory;
import com.shiftedtech.spree.Util.Locators.DriverFactoryNew;
import com.shiftedtech.spree.pom.ApplicationController;
import com.shiftedtech.spree.pom.ApplicationControllerTwo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Setup extends FunctionalMethods {


  //  protected ApplicationControllerTwo spreeTwo= null;
    protected ThreadLocal<ApplicationController> spreeDriver= new ThreadLocal<>();

    protected  ThreadLocal<WebDriver> driverCollection= new ThreadLocal<>();

    @Before
    public void setup(){
          // WebDriver driver;
       /* String driverpath = System.getProperty("user.dir")+"/Drivers/chromedriver.exe/";
            System.setProperty("webdriver.chrome.driver",driverpath);*/

          //  DriverFactoryNew.getInstance();

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driverCollection.set(driver);
            driver().navigate().to("http://spree.shiftedtech.com");
            driver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver().manage().window().maximize();

            spreeDriver.set(new ApplicationController(driver()));
           // spreeTwo=ApplicationControllerTwo.getInstance(driverCollection.get());
        }


        public ApplicationController spree()
        {

            return spreeDriver.get();
        }

        public WebDriver driver(){
        return driverCollection.get();
        }


    @After
        public void tearDown(){
        driverCollection.get().quit();
        driverCollection.get().close();
    }


}
