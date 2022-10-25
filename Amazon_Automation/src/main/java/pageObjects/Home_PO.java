package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_PO extends Base_PO{

    public Home_PO() {
        super();
    }

    private @FindBy(id = "twotabsearchtextbox")
    WebElement searchText;

    private @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    public void navigateToHomePage() {
        navigateToUrl("https://www.amazon.com/");
    }

    public void searchItem(String item) {
        senKeys(searchText, item);
    }

    public void clickOnSearchButton() {
        waitForElementAndClick(searchButton);
    }


}
