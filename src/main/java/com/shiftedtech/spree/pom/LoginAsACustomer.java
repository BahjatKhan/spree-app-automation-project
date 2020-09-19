package com.shiftedtech.spree.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginAsACustomer extends PageBase{

    LoginAsACustomer instance;
    @FindBy(name = "spree_user[email]")
    private WebElement UserName;
    @FindBy(id="spree_user_password")
    private WebElement PassWord;
    @FindBy(name="commit")
    private WebElement commit;
    @FindBy(css = ".alert-success")
    private WebElement SuccessMessage;
    @FindBy (css = ".alert-error")
    private WebElement InvalidMessage;
    @FindBy(partialLinkText = "Existing")
    private WebElement LoginAsACustomer;


    public LoginAsACustomer(WebDriver driver){
        super(driver);
        AjaxElementLocatorFactory cp= new AjaxElementLocatorFactory(driver,20);
        PageFactory.initElements(cp,this);

    }



    public void VerifyLoginSuccess(String expectedMessage){
        String pageMessage= SuccessMessage.getText();
        Assert.assertNotNull(pageMessage);
        Assert.assertEquals(expectedMessage,pageMessage);

    }

    public void VerifyInvalidLogin(String expectedMessage){

        String pageMessage= InvalidMessage.getText();
        Assert.assertNotNull(pageMessage);
        Assert.assertEquals(expectedMessage,pageMessage);
    }
    public void ClickLoginAsACustomerButton(){
        Delay(20);
        LoginAsACustomer.click();
    }

    public void Commit(){

        commit.click();
    }

}
