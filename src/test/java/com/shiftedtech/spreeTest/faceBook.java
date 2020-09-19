package com.shiftedtech.spreeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class faceBook {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");
        driver.manage().window().maximize();

        driver.findElement(By.id("email")).sendKeys("nirjhor2");
        driver.findElement(By.id("pass")).sendKeys("1234");
        driver.findElement(By.id("loginbutton")).click();

        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Afzal Hasib");
        driver.findElement(By.xpath("//body[@dir='ltr']")).click();
        driver.findElement(By.linkText("Afzal")).click();
        driver.findElement(By.xpath("//div[@data-novc='1']")).sendKeys("Hi");
        WebElement textbox = driver.findElement(By.xpath("//div[@data-novc='1']"));
        textbox.sendKeys(Keys.ENTER);
    }

}
