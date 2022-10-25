package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO{
    public Login_PO() {
        super();
    }

    private @FindBy(xpath = "//span[@class='nav-action-inner' and text()='Sign in']")
    WebElement signInButton;

    private @FindBy(xpath = "//span[@class='nav-action-inner' and text()='Sign in']")
    WebElement signButton;

    private @FindBy(id = "ap_email")
    WebElement emailField;

    private @FindBy(id = "continue")
    WebElement continueButton;

    private @FindBy(xpath = "//span[@class=\"a-list-item\"]")
    WebElement unsuccessfulLoginWarningMessage;

    public void navigateToHomePage() {
        navigateToUrl("https://www.amazon.com/");
    }

    public void clickOnSignInButton() {
        waitForElementAndClick(signButton);
    }

    public void clickOnContinueButton() {
        waitForElementAndClick(continueButton);
    }

    public void sendEmail(String textToType) {
        senKeys(emailField, textToType);
    }

}
