package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product_PO extends Base_PO{
    public Product_PO() {
        super();
    }

    private @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;

    public void addProductToTheCart() {
        waitForElementAndClick(addToCartButton);
    }
}
