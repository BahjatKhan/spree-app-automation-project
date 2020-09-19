package com.shiftedtech.spreeTest;

import org.junit.Test;

public class TestScriptWithThread extends Setup {


    @Test
    public void test1(){

        spree().SpreeTshirtPage().ClickRubiOnRailsTshirt();
        spree().SpreeTshirtPage().ClickAddCartButton();
        spree().SpreeTshirtPage().CheckOutLink();
        spree().LoginAsACustomer().ClickLoginAsACustomerButton();
        spree().LoginPage().Login("shiftqa01@gmail.com","shiftedtech");


    }
    @Test
    public void test2(){

        spree().SpreeTshirtPage().ClickRubiOnRailsTshirt();
        spree().SpreeTshirtPage().ClickAddCartButton();
        spree().SpreeTshirtPage().CheckOutLink();
        spree().LoginAsACustomer().ClickLoginAsACustomerButton();
        spree().LoginPage().Login("shiftqa01@gmail.com","shiftedtech");


    }











}
