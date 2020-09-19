package com.shiftedtech.spreeTest;

import com.shiftedtech.spree.Util.Locators.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class TestScriptKW {

   protected WebDriver driver=null;
   private String keywordFileLocation=null;

    @Before
    public void setup(){
        keywordFileLocation= System.getProperty("user.dir")+"/src/test/resources/KW-SCRIPTS/TestScript1.xlsx";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
     //   driver.navigate().to("http://spree.shiftedtech.com/");
    }

    @Test
    public void validTest1(){
        ExcelReader excelReader= new ExcelReader(keywordFileLocation);
        String [][] excelData = excelReader.getExcelSheetData(0);
        System.out.println(Arrays.deepToString(excelData));


    }

    @After
    public void tearDown(){
            driver.close();
            driver.quit();

    }









}
