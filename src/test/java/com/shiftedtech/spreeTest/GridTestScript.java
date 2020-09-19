package com.shiftedtech.spreeTest;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GridTestScript extends Setup {



    @Test
    public void validTest(){
        spree().SpreeTshirtPage().ClickRubiOnRailsTshirt();
        spree().SpreeTshirtPage().ClickAddCartButton();
        spree().SpreeTshirtPage().CheckOutLink();
        spree().LoginAsACustomer().ClickLoginAsACustomerButton();
        spree().LoginPage().Login("shiftqa01@gmail.com","shiftedtech");

    }

    @Test
    public void invalidTest(){
        spree().SpreeTshirtPage().ClickRubiOnRailsTshirt();
        spree().SpreeTshirtPage().ClickAddCartButton();
        spree().SpreeTshirtPage().CheckOutLink();
        spree().LoginAsACustomer().ClickLoginAsACustomerButton();
        spree().LoginPage().Login("shiftqa01@gmail.com","shiftedtech");


    }









}
