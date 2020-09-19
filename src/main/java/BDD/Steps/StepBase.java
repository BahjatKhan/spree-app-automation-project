package BDD.Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepBase {

    protected WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //  driver.navigate().to("http://spree.shiftedtech.com");
        WebDriverWait wait = new WebDriverWait(driver,30);

     //   wait.until(ExpectedConditions.)

    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }



    @Given("not a validated user")
    public void not_a_validated_user() {
        driver.manage().deleteAllCookies();
    }

    @When("user browse to the site {string}")
    public void user_browse_to_the_site(String string) {
        driver.navigate().to("http://spree.shiftedtech.com");
    }

    @Then("hompage should display")
    public void hompage_should_display() {
        String actualTitle= driver.getTitle();
        Assert.assertEquals("Spree Demo Site",actualTitle);
    }

    @When("user click login page")
    public void user_click_login_page() {
        driver.findElement(By.linkText("Login")).click();
    }

    @Then("loginpage should display")
    public void loginpage_should_display() {
        String actualTtile = driver.getTitle();
        Assert.assertEquals("Login - Spree Demo Site",actualTtile);
    }

    @When("user enter valid email address {string}")
    public void user_enter_valid_email_address(String Email) {
        driver.findElement(By.name("spree_user[email]")).sendKeys(Email);
    }

    @When("user enter valid password address {string}")
    public void user_enter_valid_password_address(String Password) {
        driver.findElement(By.id("spree_user_password")).sendKeys(Password);
    }

    @Then("user click login button")
    public void user_click_login_button() {
        driver.findElement(By.name("commit")).click();
    }









}
