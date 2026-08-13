// InventoryPage.java
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

    private By productNames =
            By.className("inventory_item_name");

    // Constructor
    public InventoryPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    // Get Inventory page title
    public String getInventoryTitle() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        inventoryTitle
                )
        ).getText();
    }

    // Add specific product to cart
    public void addProductToCart(String productName) {

        By addToCartButton = By.xpath(
                "//div[text()='" + productName + "']"
                        + "/ancestor::div[contains(@class,'inventory_item')]"
                        + "//button"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        addToCartButton
                )
        ).click();
    }

    // Get all complete product cards
    public List<WebElement> getAllProducts() {

        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        productItems
                )
        );
    }

    // Get only product names
    public List<WebElement> getProductNames() {

        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        productNames
                )
        );
    }
}