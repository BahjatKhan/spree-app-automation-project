package com.shiftedtech.spree;

import org.openqa.selenium.By;

public class SpreeX {

    private static SpreeX instance;

    private LoginPage LoginPage;
    private Login Login;
    private VerifyLogin VerifyLogin;


    private SpreeX(){
        LoginPage=new LoginPage();
        Login=new Login();
        VerifyLogin= new VerifyLogin();

    }

    public static SpreeX getInstance(){

        if (instance == null){
            instance= new SpreeX();
        }
        return instance;
    }
        public LoginPage getLoginPage(){
        return LoginPage;
        }
        public Login getLogin(){
             return Login;
        }
        public VerifyLogin getVerifyLogin(){
        return VerifyLogin;
    }

    public class LoginPage {

        public final By CLICK_LOGIN_PAGE = By.linkText("Login");
    }

    public class Login{

        public final By EMAIL_ADDRESS= By.name("spree_user[email]");
        public final By PASSWORD_VALUE= By.id("spree_user_password");
        public final By CLICK_LOGIN_BUTTON= By.name("commit");
    }

    public class VerifyLogin{

        public  final By VALUE_OF_ACTUAL_VALID_LOGIN= By.cssSelector(".alert-success");
        public  final By VALUE_OF_ACTUAL_INVALID_LOGIN = By.cssSelector(".alert-error");
    }



}
