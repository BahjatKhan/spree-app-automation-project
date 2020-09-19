package com.shiftedtech.spree.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends PageBase {


    public LoginPage(WebDriver driver) {
        super(driver);
        AjaxElementLocatorFactory ajaxElementLocatorFactory= new AjaxElementLocatorFactory(driver,20);
        PageFactory.initElements(ajaxElementLocatorFactory,this);

        // PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }

    @FindBy(name = "spree_user[email]")
        private WebElement UserName;

    @FindBy(id = "spree_user_password")
        private WebElement PasswordName;

    @FindBy(name ="commit")
        private WebElement Click;

    @FindBy(css = ".alert-success")
        private WebElement SuccessMessage;

    @FindBy(linkText = "Login")
        private WebElement ClickLogin;

    public void ClickLoginPageButton(){
        ClickLogin.click();
    }

    public void Login(String Email,String Password){

        UserName.sendKeys(Email);
       // Delay(10);
        PasswordName.sendKeys(Password);
       // Delay(10);
        Click.click();
       // Delay(10);
    }

    public void VerifyLoginSuccess(String expectedMessage){
        String pageMessage= SuccessMessage.getText();
        Assert.assertNotNull(pageMessage);
        Assert.assertEquals(expectedMessage,pageMessage);

    }


}
