package com.shiftedtech.spreeTest;

import org.junit.Test;

public class SpreeWithPageObjectModel1 extends SpreeBasePageObjectModel {


//    @Test
//    public void validTest1(){
//
//        SpreeTshirtPage.ClickRubiOnRailsTshirt();
//        SpreeTshirtPage.ClickAddCartButton();
//        SpreeTshirtPage.CheckOutLink();
//        SpreeTshirtPage.LoginAsACustomer();
//        LoginAsACustomer.Login("shiftqa01@gmail.com","shiftedtech");
//        LoginAsACustomer.VerifyLoginSuccess("Logged in successfully");
//    }
//
//    @Test
//    public void invalidTest1(){
//
//        SpreeTshirtPage.ClickRubiOnRailsTshirt();
//        SpreeTshirtPage.ClickAddCartButton();
//        SpreeTshirtPage.CheckOutLink();
//        SpreeTshirtPage.LoginAsACustomer();
//        LoginAsACustomer.Login("shiftqa01@gmail.com","shiftedtechxxx");
//        LoginAsACustomer.VerifyInvalidLogin("Invalid email or password.");


   // }

    @Test
    public void validTest2(){

        spree.SpreeTshirtPage().ClickRubiOnRailsTshirt();
        spree.SpreeTshirtPage().ClickAddCartButton();
        spree.SpreeTshirtPage().CheckOutLink();
        spree.LoginAsACustomer().ClickLoginAsACustomerButton();
        spree.LoginPage().Login("shiftqa02@gmail.com","shiftedtech");
        spree.LoginAsACustomer().VerifyLoginSuccess("Logged in successfully");




    }


}
