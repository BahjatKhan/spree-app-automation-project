package com.shiftedtech.spree;

import org.junit.Assert;

public class FunctionalMethods extends ActionBasedFunctions {



    public void VerifyHomePage(){
        String getHomePage= driver.getTitle();
        Assert.assertEquals("Spree Demo Site",getHomePage);
    }
    public void getPageTitleAndVerify(String pageTitle){
        String getPageTitle= driver.getTitle();
        Assert.assertEquals(pageTitle,getPageTitle);


    }
    public void goToLoginPage(){
        click(Spree.LoginPage.CLICK_LOGIN_PAGE);
       // driver.findElement(By.linkText("Login")).click();

    }
    public void login(String email,String password){


        typeText(Spree.Login.EMAIL_ADDRESS,email);
        typeText(Spree.Login.PASSWORD_VALUE,password);
        click(Spree.Login.CLICK_LOGIN_BUTTON);


       // driver.findElement(By.name("spree_user[email]")).sendKeys(email);
      //  driver.findElement(By.id("spree_user_password")).sendKeys(password);
       // driver.findElement(By.name("commit")).click();

    }
    public void verifyValidLogin(String VerifyMessage){

          Verify(Spree.VerifyLogin.VALUE_OF_ACTUAL_VALID_LOGIN,VerifyMessage);

    }

    public void verifyInvalidLogin(String VerifyMessage){

        Verify(Spree.VerifyLogin.VALUE_OF_ACTUAL_INVALID_LOGIN,VerifyMessage);

    }
}
