package com.shiftedtech.spree.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.xml.ws.WebEndpoint;

public class SpreeTshirtPage extends PageBase {
    @FindBy(className = "info")
    private WebElement TshirtLink;
    @FindBy (id = "add-to-cart-button")
    private WebElement AddToCart;
    @FindBy (id = "checkout-link")
    private WebElement CheckOutLink;


    public SpreeTshirtPage(WebDriver driver) {
        super(driver);

        AjaxElementLocatorFactory d= new AjaxElementLocatorFactory(driver,20);

        PageFactory.initElements(d,this);
    }


    public void ClickRubiOnRailsTshirt(){
        Delay(20);
        TshirtLink.click();

    }
    public void ClickAddCartButton(){
        Delay(30);
        AddToCart.click();
    }
    public void CheckOutLink(){
        CheckOutLink.click();
    }







    // PageFactory.initElements(driver,this);

//    public HomePage(WebDriver driver){
//        super(driver);
//        PageFactory.initElements(driver,this);
//    }


        // Methods



}
