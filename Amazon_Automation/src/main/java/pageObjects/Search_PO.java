package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search_PO extends Base_PO{
    public Search_PO() {
        super();
    }

    private @FindBy(xpath = "//span[@class='a-size-base a-color-base' and text()='Apple'][1]")
    WebElement appleBrand;

    private @FindBy(xpath = "//i[@class=\"a-icon a-icon-star-medium a-star-medium-4\"]")
    WebElement reviewsAboveFourStar;

    private @FindBy(id = "low-price")
    WebElement lowPriceText;

    private @FindBy(id = "high-price")
    WebElement highPriceText;

    private @FindBy(xpath = "//input[@class=\"a-button-input\"]")
    WebElement goButton;

    private @FindBy(id = "a-autoid-0-announce")
    WebElement sortByButton;

    private @FindBy(id = "s-result-sort-select_1")
    WebElement sortPricesLowToHigh;

    private @FindBy(xpath = "(//span[@class=\"a-expander-prompt\" and text()='See more'])[1]")
    WebElement seeMoreButtonForBrands;

    public void clickOnSeeMoreButtonForBrands() {
        waitForElementAndClick(seeMoreButtonForBrands);
    }

    public void clickOnAppleBrand() {
        waitForElementAndClick(appleBrand);
    }

    public void clickOnReviewsAboveFourStar() {
        waitForElementAndClick(reviewsAboveFourStar);
    }

    public void enterMinPrice(String minPrice) {
        senKeys(lowPriceText, minPrice);
    }

    public void enterMaxPrice(String maxPrice) {
        senKeys(highPriceText, maxPrice);
    }

    public void clickOnGoButton() {
        waitForElementAndClick(goButton);
    }

    public void clickOnSortButton() {
        waitForElementAndClick(sortByButton);
    }

    public void sortPricesFromLowToHigh() {
        waitForElementAndClick(sortPricesLowToHigh);
    }

}
