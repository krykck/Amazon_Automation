package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;


import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class Login extends Base_PO {
    private WebDriver driver = getDriver();

    private Login_PO login_po;

    public Login(Login_PO login_po) {
        this.login_po = login_po;
    }

    private WebDriverWait waiter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }

    @Given("I access amazon.com")
    public void i_access_amazon_com() {
        //driver.get("https://www.amazon.com/");
        login_po.navigateToHomePage();
    }

    @When("I click on Sign-in button")
    public void i_click_on_sign_in_button() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
        //waiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-action-inner' and text()='Sign in']"))).click();
        login_po.clickOnSignInButton();
    }
    @And("I enter random input {} for email")
    public void i_enter_random_input_for_email(String input) {
        //waiter().until(ExpectedConditions.presenceOfElementLocated(By.id("ap_email"))).sendKeys("fghfhfh@e.com");
        login_po.sendEmail(input);
    }
    @And("I click on continue button")
    public void i_click_on_continue_button() {
        //driver.findElement(By.id("continue")).click();
        login_po.clickOnContinueButton();
    }
    @Then("I should see warning message")
    public void i_should_see_warning_message() {
        String actualMessage = waiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"a-list-item\"]"))).getText();
        String expectedMessage = "We cannot find an account with that email address";
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
