package com.shiftedtech.spree;

import org.openqa.selenium.By;

public class Spree {

    public static class LoginPage {

        public static final By CLICK_LOGIN_PAGE = By.linkText("Login");
    }

    public static class Login{

        public static final By EMAIL_ADDRESS= By.name("spree_user[email]");
        public static final By PASSWORD_VALUE= By.id("spree_user_password");
        public static final By CLICK_LOGIN_BUTTON= By.name("commit");
    }

    public static class VerifyLogin{

        public static final By VALUE_OF_ACTUAL_VALID_LOGIN= By.cssSelector(".alert-success");
        public static final By VALUE_OF_ACTUAL_INVALID_LOGIN = By.cssSelector(".alert-error");
    }



}
