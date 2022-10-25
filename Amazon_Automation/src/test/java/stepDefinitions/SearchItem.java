package stepDefinitions;

import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.*;
import org.testng.Assert;
import pageObjects.*;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static driver.DriverFactory.getDriver;

public class SearchItem extends Base_PO {
    private WebDriver driver = getDriver();

    private WebDriverWait waiter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }

    private Search_PO search_po;
    private Home_PO home_po;
    private Product_PO product_po;
    private Cart_PO cart_po;

    public SearchItem(Search_PO search_po, Home_PO home_po, Product_PO product_po, Cart_PO cart_po) {
        this.search_po = search_po;
        this.home_po = home_po;
        this.product_po = product_po;
        this.cart_po = cart_po;
    }

    @Given("I am on the amazon.com")
    public void i_am_on_the_amazon_com() {
        //driver.get("https://www.amazon.com/");
        home_po.navigateToHomePage();
    }

    @When("I search {string}")
    public void i_search(String item) {
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item);
        //driver.findElement(By.id("nav-search-submit-button")).click();
        home_po.searchItem(item);
        home_po.clickOnSearchButton();
    }

    @And("I select Apple brand")
    public void i_select_Apple_brand() {
        //waiter().until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class=\"a-expander-prompt\" and text()='See more'])[1]"))).click();
        //waiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-size-base a-color-base' and text()='Apple'][1]"))).click();
        search_po.clickOnSeeMoreButtonForBrands();
        search_po.clickOnAppleBrand();
    }

    @And("I select the highest customer reviews")
    public void i_select_customer_reviews_above() {
        //waiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class=\"a-icon a-icon-star-medium a-star-medium-4\"]"))).click();
        search_po.clickOnReviewsAboveFourStar();
    }

    @And("I enter min price: {string}")
    public void i_enter_min_price_$(String min) {
        //driver.findElement(By.id("low-price")).sendKeys(min);
        search_po.enterMinPrice(min);
    }

    @And("I enter max price: {string}")
    public void i_enter_max_price_$(String max) {
        //driver.findElement(By.id("high-price")).sendKeys(max);
        search_po.enterMaxPrice(max);
    }

    @And("I click on Go button")
    public void i_click_on_go_button() {
        //waiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class=\"a-button-input\"]"))).click();
        search_po.clickOnGoButton();
    }

    @And("I sort by Price: Low to High")
    public void i_sort_by_price_low_to_high() {
        //driver.findElement(By.id("a-autoid-0-announce")).click();
        //driver.findElement(By.id("s-result-sort-select_1")).click();
        search_po.clickOnSortButton();
        search_po.sortPricesFromLowToHigh();
    }

    @And("I select the first available product")
    public void i_select_the_first_available_product() {
        List<WebElement> priceWholeWebElement = waiter().until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class=\"a-price-whole\"]")));
        priceWholeWebElement.get(0).click();
    }

    @And("I add the product to the shopping cart")
    public void i_add_the_product_to_the_shopping_cart() {
        //waiter().until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button"))).click();
        product_po.addProductToTheCart();
    }

    @Then("I should see the product added to the shopping cart")
    public void i_should_see_the_product_added_to_the_shopping_cart() {
        //String actualMessage = waiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"a-size-medium-plus a-color-base sw-atc-text a-text-bold\"]"))).getText();
        String expectedMessage = "Added to Cart";
        //Assert.assertEquals(actualMessage,expectedMessage);
        cart_po.checkAddedToCartMessage(expectedMessage);
    }
}
