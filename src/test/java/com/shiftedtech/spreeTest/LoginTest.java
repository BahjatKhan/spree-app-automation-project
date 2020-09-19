package com.shiftedtech.spreeTest;

import com.shiftedtech.spree.Spree;
import com.shiftedtech.spree.SpreeX;
import com.shiftedtech.spree.pom.ApplicationControllerTwo;
import org.junit.Test;

public class LoginTest extends Setup {

    private SpreeX sp = SpreeX.getInstance();


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
        click(Spree.LoginPage.CLICK_LOGIN_PAGE);
        getPageTitleAndVerify("Login - Spree Demo Site");
        typeText(Spree.Login.EMAIL_ADDRESS,"Shiftqa01@gmail.com");
        typeText(Spree.Login.PASSWORD_VALUE,"shiftedtechxxx");
        click(Spree.Login.CLICK_LOGIN_BUTTON);
      //  verifyValidLogin();
        verifyInvalidLogin("Invalid email or password.");

    }

    @Test
    public void validTest1(){

       // SpreeX sp = SpreeX.getInstance();
        getPageTitleAndVerify("Spree Demo Site");
        click(sp.getLoginPage().CLICK_LOGIN_PAGE);
        getPageTitleAndVerify("Login - Spree Demo Site");
        typeText(sp.getLogin().EMAIL_ADDRESS,"shiftqa01@gmail.com");
        typeText(sp.getLogin().PASSWORD_VALUE,"shiftedtech");
        click(sp.getLogin().CLICK_LOGIN_BUTTON);
        Verify(sp.getVerifyLogin().VALUE_OF_ACTUAL_VALID_LOGIN,"Logged in successfully");



    }

    @Test
    public void CartCheck(){
//
//        spreeTwo.SpreeTshirtPage().ClickRubiOnRailsTshirt();
//        spreeTwo.SpreeTshirtPage().ClickAddCartButton();
//        spreeTwo.SpreeTshirtPage().CheckOutLink();
//        spreeTwo.LoginAsACustomer().ClickLoginAsACustomerButton();
//        spreeTwo.PageBase().Delay(2000);
//        spreeTwo.LoginPage().Login("shiftqa01@gmail.com","shiftedtech");
//       // spreeTwo .LoginPage().ClickLoginButton();
//        spreeTwo.LoginPage().VerifyLoginSuccess("Logged in successfully");

    }




}
