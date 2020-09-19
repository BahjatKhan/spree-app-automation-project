package com.shiftedtech.spree;

import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionBasedFunctions {

    protected WebDriver driver;

    public void typeText(By by, String text){
        WebElement element= driver.findElement(by);
        element.sendKeys(text);
    }

    public void click(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void Verify(By by , String expected){
        WebElement element= driver.findElement(by);
        String invalidLoginMessage= element.getText();
      Assert.assertEquals(expected,invalidLoginMessage);

      //Assert.assertEquals(expected, invalidLoginMessage);
    //  System.out.println("Verification Passed");


    }

}
