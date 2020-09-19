package com.shiftedtech.spree.pom;

import org.openqa.selenium.WebDriver;

public class ApplicationController {
    private PageBase PageBase;
    private LoginAsACustomer LoginAsACustomer;
    private SpreeTshirtPage SpreeTshirtPage;
    private LoginPage LoginPage;

    protected WebDriver driver;


    public ApplicationController(WebDriver driver)
    {
        this.driver=driver;
    }


    public LoginAsACustomer LoginAsACustomer(){


        if (LoginAsACustomer ==null)
        {
            LoginAsACustomer = new LoginAsACustomer(driver);
        }
        return LoginAsACustomer;
    }

    public SpreeTshirtPage SpreeTshirtPage(){

       if (SpreeTshirtPage==null){
           SpreeTshirtPage= new SpreeTshirtPage(driver);
       }

        return SpreeTshirtPage;
    }

    public PageBase PageBase(){

        if (PageBase==null){
            PageBase=new PageBase(driver);
        }
        return PageBase;
    }

    public LoginPage LoginPage(){

        if (LoginPage==null){

            LoginPage=new LoginPage(driver);
        }
        return LoginPage;
    }

      //  public <T> void




}
