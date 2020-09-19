package com.shiftedtech.spreeTest;

import com.shiftedtech.spree.pom.ApplicationController;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SpreeBasePageObjectModel {

    protected WebDriver driver;
    protected ApplicationController spree=null;


    @Before
    public void setup() {
       /* String driverpath = System.getProperty("user.dir")+"/Drivers/chromedriver.exe/";
            System.setProperty("webdriver.chrome.driver",driverpath);*/

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("http://spree.shiftedtech.com");
        driver.manage().window().maximize();

        spree= new ApplicationController(driver);


    }



    @After
    public void tearDown(){
        driver.close();
        driver.quit();
        spree=null;

    }


}
