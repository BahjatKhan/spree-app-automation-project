package com.shiftedtech.spreeTest;

import com.shiftedtech.spree.Util.RetriveDataFromExcelManager;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)

public class SpreeDataDrivenTwo extends SpreeBasePageObjectModel{


        @Parameters(source = RetriveDataFromExcelManager.class)

        @Test
        public void validTest1(String email,String password){

        spree.LoginPage().ClickLoginPageButton();
        spree.LoginPage().Login(email,password);
        spree.PageBase().Delay(5000);
        spree.LoginPage().VerifyLoginSuccess("Logged in successfully");


        }














        }
