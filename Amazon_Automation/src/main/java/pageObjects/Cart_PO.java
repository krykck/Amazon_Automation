package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart_PO extends Base_PO{
    public Cart_PO() {
        super();
    }

    private @FindBy(xpath = "//span[@class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]")
    WebElement cartAddedMessage;

    public void checkAddedToCartMessage(String expectedText) {
        getTextAndValidate(cartAddedMessage, expectedText);
    }
}
