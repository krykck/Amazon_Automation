package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class Base_PO {
    private Base_PO base_po;

    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver driver() {
        return DriverFactory.getDriver();
    }

    //navigate to url
    public void navigateToUrl(String url) {
        getDriver().get(url);
    }

    //sendKeys with webElement
    public void senKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    //sendKeys with id
    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(by)).sendKeys(textToType);
    }

    //wait with webElement
    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    //wait with by
    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForPresenceOfElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(by)).click();
    }

    public void waitForPresenceOfElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    //wait and click with element
    public void waitForElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    //wait and click with by
    public void waitForElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    //wait and get text with WebElement
    public String waitForElementAndGetText(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    //wait and get text with By
    public String waitForElementAndGetText(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
    }

    public void getTextAndValidate(WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String actualText = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public void getTextAndValidate(By by, String expectedText) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
        Assert.assertEquals(actualText, expectedText);
    }







}
