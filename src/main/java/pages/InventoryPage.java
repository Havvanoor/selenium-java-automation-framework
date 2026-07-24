package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {

    private WebDriver driver;

    private WebDriverWait wait;


    // Locators

    private By inventoryTitle =
            By.className("title");

    private By productItems =
            By.className("inventory_item");


    // Constructor

    public InventoryPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

    }


    // Get Inventory Page Title

    public String getInventoryTitle() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        inventoryTitle
                )
        ).getText();

    }


    // Add Product to Cart

    public void addProductToCart(
            String productName) {

        By addToCartButton = By.xpath(
                "//div[text()='"
                        + productName
                        + "']/ancestor::div[contains(@class,'inventory_item')]"
                        + "//button"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addToCartButton
                )
        ).click();

    }


    // Get all products

    public List<WebElement> getAllProducts() {

        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        productItems
                )
        );

    }

}