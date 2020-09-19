package com.shiftedtech.spree.pom;

import org.openqa.selenium.WebDriver;

public class ApplicationControllerTwo {

    public static ApplicationControllerTwo instance=null;

    private PageBase PageBase;
    private LoginAsACustomer LoginAsACustomer;
    private SpreeTshirtPage SpreeTshirtPage;
    private LoginPage LoginPage;

  //  private static WebDriver driver;


    private ApplicationControllerTwo(WebDriver driver)
    {
        PageBase=new PageBase(driver);
        LoginAsACustomer=new LoginAsACustomer(driver);
        SpreeTshirtPage=new SpreeTshirtPage(driver);
        LoginPage=new LoginPage(driver);
    }

    public static ApplicationControllerTwo getInstance(WebDriver driver){

        if (instance ==null){
            instance =new ApplicationControllerTwo(driver);
        }
        return instance;

    }

    public LoginAsACustomer LoginAsACustomer(){

        return LoginAsACustomer;
    }

    public SpreeTshirtPage SpreeTshirtPage(){

        return SpreeTshirtPage;
    }

    public PageBase PageBase(){

        return PageBase;
    }

    public LoginPage LoginPage(){

        return LoginPage;
    }




}
