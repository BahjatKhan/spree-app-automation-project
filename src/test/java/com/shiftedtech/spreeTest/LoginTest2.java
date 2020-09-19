package com.shiftedtech.spreeTest;

import com.shiftedtech.spree.Spree;
import com.shiftedtech.spree.Util.Locators.DriverFactoryNew;
import com.shiftedtech.spree.Util.PropertyFileObjectRepoManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByLinkText;

import java.util.concurrent.TimeUnit;

public class LoginTest2 extends Setup {

    private PropertyFileObjectRepoManager or = PropertyFileObjectRepoManager.getInstance();
    @Override
    public void setup(){
        super.setup();
        or.reset();
        or.load(System.getProperty("user.dir")+"/src/test/resources/ObjectRepo.properties");
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }


    @Test
    public void validTest1(){

        getPageTitleAndVerify("Spree Demo Site");
        click(or.getLocator("HOME_PAGE.CLICK_LOGIN_PAGE"));
        driver.findElement(or.getLocator("HOME_PAGE.CLICK_LOGIN_PAGE")).click();
      //  driver.findElement(By.linkText("login")).click();
        getPageTitleAndVerify("Login - Spree Demo Site");
        typeText(or.getLocator("LOGIN.EMAIL_ADDRESS"),"Shiftqa01@gmail.com");
        typeText(or.getLocator("LOGIN.PASSWORD_VALUE"),"shiftedtech");
        click(or.getLocator("LOGIN.CLICK_LOGIN_BUTTON"));
        Verify(or.getLocator("VerifyLogin.VALUE_OF_ACTUAL_VALID_LOGIN"),"Logged in successfully");

    }


    @Test
    public void validTest(){

        getPageTitleAndVerify("Spree Demo Site");
        goToLoginPage();
        getPageTitleAndVerify("Login - Spree Demo Site");
        login("shiftqa01@gmail.com","shiftedtech");
        getPageTitleAndVerify("Spree Demo Site");
        verifyValidLogin("Logged in successfully");
        getPageTitleAndVerify("Spree Demo Site");

    }
    @Test
    public void invalidTest(){
        getPageTitleAndVerify("Spree Demo Site");
        //goToLoginPage();
        click(Spree.LoginPage.CLICK_LOGIN_PAGE);
        getPageTitleAndVerify("Login - Spree Demo Site");
        login("shiftqa01@gmail.com","shiftedtechxxx");
        getPageTitleAndVerify("Login - Spree Demo Site");
        Verify(Spree.VerifyLogin.VALUE_OF_ACTUAL_INVALID_LOGIN,"Invalid email or password.");
        //verifyInvalidLogin("Invalid email or password.");
    }
    @Test
    public void invalidTest1(){

        click( By.linkText("Login"));
        click(Spree.LoginPage.CLICK_LOGIN_PAGE);
        getPageTitleAndVerify("Login - Spree Demo Site");
        typeText(Spree.Login.EMAIL_ADDRESS,"Shiftqa01@gmail.com");
        typeText(Spree.Login.PASSWORD_VALUE,"shiftedtechxxx");
        click(Spree.Login.CLICK_LOGIN_BUTTON);
      //  verifyValidLogin();
        verifyInvalidLogin("Invalid email or password.");

    }

    @Test
    public void validTest2(){
        spree().LoginPage().ClickLoginPageButton();
        spree().LoginPage().Login("shiftqa01@gmail.com","shiftedtech");
        spree().LoginPage().VerifyLoginSuccess("Logged in successfully");
    }

    @Test
    public void validTest3() throws InterruptedException {

        WebElement element=((FindsByLinkText)driver()).findElementByLinkText("Login");
            element.click();
            Thread.sleep(5000);
    }


}
