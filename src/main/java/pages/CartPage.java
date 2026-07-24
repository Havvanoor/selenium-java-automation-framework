package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;

    private WebDriverWait wait;


    // Locators

    private By cartButton =
            By.className("shopping_cart_link");

    private By productName =
            By.className("inventory_item_name");

    private By productQuantity =
            By.className("cart_quantity");

    private By productPrice =
            By.className("inventory_item_price");


    // Constructor

    public CartPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

    }


    // Open Cart

    public void openCart() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        cartButton
                )
        ).click();

    }


    // Get Product Name

    public String getProductName() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productName
                )
        ).getText();

    }


    // Get Product Quantity

    public String getProductQuantity() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productQuantity
                )
        ).getText();

    }


    // Get Product Price

    public String getProductPrice() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        productPrice
                )
        ).getText();

    }

}