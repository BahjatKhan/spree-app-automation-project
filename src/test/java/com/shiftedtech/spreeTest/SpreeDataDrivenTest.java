package com.shiftedtech.spreeTest;

import com.shiftedtech.spree.pom.SpreeDataDrivenTestData;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;


//    private String email,password;
//
//    public SpreeDataDrivenTest(String email,String password){
//
//        this.email=email;
//        this.password=password;
//    }
//    @Parameters(
//            {
//                    "shiftqa01@gmail.com,  shiftedtech",
//
//                    "shiftqa02@gmail.com, shiftedtech"
//
//
//            }

//    )
@RunWith(JUnitParamsRunner.class)
public class SpreeDataDrivenTest extends SpreeBasePageObjectModel {

    @Test
    @Parameters(source = SpreeDataDrivenTestData.class)

    public void validTest1(String email,String password) {
        spree.PageBase().Delay(20);
        spree.SpreeTshirtPage().ClickRubiOnRailsTshirt();
        spree.SpreeTshirtPage().ClickAddCartButton();
        spree.SpreeTshirtPage().CheckOutLink();
        spree.LoginAsACustomer().ClickLoginAsACustomerButton();
        spree.LoginPage().Login(email,password);
        spree.LoginAsACustomer().VerifyLoginSuccess("Logged in successfully");
    }

//    @Parameterized.Parameters(name = "{index}: Test with X={0}, Y={1})")
//    public static Iterable<Object[]> iterator() {
//
//        return Arrays.asList(new Object[][]{
//                {"shiftqa01@gmail.com", "shiftedtech"},
//                {"shiftqa02@gmail.com", "shiftedtech"}}
//        );
//
//    }

//    @Parameterized.Parameters(name = "{index}: email={0}, password={1})")
//    public static Iterable<Object[]> iterator() {
//
//        Object[][] data= new Object[2][2];
//
//        data[0][0]="shiftqa01@gmail.com";
//        data[0][1]="shiftedtech";
//        data[1][0]="shiftqa02@gmail.com";
//        data[1][1]="shiftedtech";
//
//        return Arrays.asList(data);
//
//
//    }

}

